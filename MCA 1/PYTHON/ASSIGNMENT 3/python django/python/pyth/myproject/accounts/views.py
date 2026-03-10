from django.shortcuts import render, redirect, get_object_or_404
from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User
from django.contrib.auth.decorators import login_required, user_passes_test
from django.contrib import messages
from django.utils.decorators import method_decorator
from django.views.generic import View, TemplateView, DetailView
from django.views.decorators.http import require_http_methods
from django.views.decorators.cache import never_cache
from django.http import JsonResponse, HttpResponseForbidden
from django.core.mail import send_mail
from django.utils import timezone
from django.urls import reverse_lazy
from django.contrib.auth.tokens import default_token_generator
from django.utils.http import urlsafe_base64_encode, urlsafe_base64_decode
from django.utils.encoding import force_bytes, force_str
from datetime import timedelta
import secrets
import logging

from .models import UserProfile, AuditLog, UserRole
from .forms import (
    CustomUserCreationForm,
    CustomAuthenticationForm,
    PasswordResetForm,
    SetNewPasswordForm,
)

logger = logging.getLogger(__name__)


def get_client_ip(request):
    """Extract client IP address from request."""
    x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
    if x_forwarded_for:
        ip = x_forwarded_for.split(',')[0]
    else:
        ip = request.META.get('REMOTE_ADDR')
    return ip


def log_audit(user, action, ip, status='SUCCESS', description='', user_agent=''):
    """Log user actions for audit trail."""
    AuditLog.objects.create(
        user=user,
        action=action,
        ip_address=ip,
        user_agent=user_agent,
        status=status,
        description=description,
    )


def is_admin(user):
    """Check if user has admin role."""
    return hasattr(user, 'profile') and user.profile.role and user.profile.role.name == 'ADMIN'


def is_verified_user(user):
    """Check if user is verified."""
    return hasattr(user, 'profile') and user.profile.is_verified


class RegisterView(View):
    """User registration view with validation."""
    template_name = 'accounts/register.html'

    def get(self, request):
        form = CustomUserCreationForm()
        return render(request, self.template_name, {'form': form})

    def post(self, request):
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save(commit=False)
            user.save()

            # Assign default USER role
            try:
                user_role = UserRole.objects.get(name='USER')
                user.profile.role = user_role
                user.profile.save()
            except UserRole.DoesNotExist:
                pass

            # Log successful registration
            log_audit(user, 'USER_REGISTRATION', get_client_ip(request), 'SUCCESS')

            messages.success(request, 'Registration successful! Please log in.')
            return redirect('accounts:login')
        else:
            for field, errors in form.errors.items():
                for error in errors:
                    messages.error(request, f"{field}: {error}")

        return render(request, self.template_name, {'form': form})


class LoginView(View):
    """Secure user login with account lockout mechanism."""
    template_name = 'accounts/login.html'
    max_login_attempts = 5
    lockout_duration = 30  # minutes

    def get(self, request):
        if request.user.is_authenticated:
            return redirect('accounts:dashboard')
        form = CustomAuthenticationForm()
        return render(request, self.template_name, {'form': form})

    def post(self, request):
        username = request.POST.get('username')
        password = request.POST.get('password')
        ip_address = get_client_ip(request)
        user_agent = request.META.get('HTTP_USER_AGENT', '')

        try:
            user = User.objects.get(username=username)
        except User.DoesNotExist:
            log_audit(None, 'LOGIN_ATTEMPT', ip_address, 'FAILURE', f'Username: {username}')
            messages.error(request, 'Invalid username or password.')
            return render(request, self.template_name, {'form': CustomAuthenticationForm()})

        # Check account lock status
        if user.profile.is_account_locked():
            log_audit(user, 'LOGIN_ATTEMPT_LOCKED', ip_address, 'FAILURE')
            messages.error(request, 'Account is locked. Please try again later or reset your password.')
            return render(request, self.template_name, {'form': CustomAuthenticationForm()})

        # Authenticate user
        auth_user = authenticate(username=username, password=password)

        if auth_user is not None:
            # Ensure profile exists
            if not hasattr(auth_user, 'profile'):
                UserProfile.objects.create(user=auth_user)

            if not auth_user.is_active:
                log_audit(auth_user, 'LOGIN_ATTEMPT_INACTIVE', ip_address, 'FAILURE')
                messages.error(request, 'Your account is inactive. Please contact support.')
                return render(request, self.template_name, {'form': CustomAuthenticationForm()})

            # Reset login attempts on successful login
            auth_user.profile.login_attempts = 0
            auth_user.profile.last_login_ip = ip_address
            auth_user.profile.save()

            login(request, auth_user)
            log_audit(auth_user, 'LOGIN_SUCCESS', ip_address, 'SUCCESS')

            messages.success(request, f'Welcome back, {auth_user.first_name or auth_user.username}!')
            return redirect('accounts:dashboard')
        else:
            # Handle failed login attempt
            user.profile.login_attempts += 1
            user.profile.last_failed_attempt = timezone.now()

            if user.profile.login_attempts >= self.max_login_attempts:
                user.profile.is_locked = True
                user.profile.locked_until = timezone.now() + timedelta(minutes=self.lockout_duration)
                user.profile.save()

                log_audit(user, 'LOGIN_FAILURE_LOCKOUT', ip_address, 'FAILURE')
                messages.error(request, f'Too many failed attempts. Account locked for {self.lockout_duration} minutes.')
            else:
                user.profile.save()
                attempts_left = self.max_login_attempts - user.profile.login_attempts
                log_audit(user, 'LOGIN_FAILURE', ip_address, 'FAILURE')
                messages.error(request, f'Invalid credentials. {attempts_left} attempts remaining.')

        return render(request, self.template_name, {'form': CustomAuthenticationForm()})


class LogoutView(View):
    """Secure user logout."""

    @method_decorator(login_required)
    def post(self, request):
        log_audit(request.user, 'LOGOUT', get_client_ip(request), 'SUCCESS')
        logout(request)
        messages.success(request, 'You have been logged out successfully.')
        return redirect('accounts:login')


class PasswordResetView(View):
    """Initiate password reset process."""
    template_name = 'accounts/password_reset.html'

    def get(self, request):
        form = PasswordResetForm()
        return render(request, self.template_name, {'form': form})

    def post(self, request):
        form = PasswordResetForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data['email']
            try:
                user = User.objects.get(email=email)

                # Generate reset token
                reset_token = secrets.token_urlsafe(32)
                user.profile.password_reset_token = reset_token
                user.profile.password_reset_token_expiry = timezone.now() + timedelta(hours=24)
                user.profile.save()

                # Send reset email
                reset_url = request.build_absolute_uri(
                    reverse_lazy('accounts:password_reset_confirm', kwargs={'token': reset_token})
                )

                send_mail(
                    'Password Reset Request',
                    f'Click the link below to reset your password:\n{reset_url}\n\nThis link expires in 24 hours.',
                    'noreply@myproject.com',
                    [email],
                    fail_silently=False,
                )

                log_audit(user, 'PASSWORD_RESET_REQUESTED', get_client_ip(request), 'SUCCESS')
                messages.success(request, 'Password reset link sent to your email.')
                return redirect('accounts:login')
            except User.DoesNotExist:
                # Don't reveal if email exists
                pass
            except Exception as e:
                logger.error(f"Password reset error: {str(e)}")
                messages.error(request, 'Error sending reset link. Please try again.')

        return render(request, self.template_name, {'form': form})


class PasswordResetConfirmView(View):
    """Confirm password reset and set new password."""
    template_name = 'accounts/password_reset_confirm.html'

    def get(self, request, token):
        try:
            profile = UserProfile.objects.get(password_reset_token=token)
            if profile.password_reset_token_expiry and timezone.now() > profile.password_reset_token_expiry:
                messages.error(request, 'Reset link has expired.')
                return redirect('accounts:password_reset')

            form = SetNewPasswordForm()
            return render(request, self.template_name, {'form': form, 'token': token})
        except UserProfile.DoesNotExist:
            messages.error(request, 'Invalid reset link.')
            return redirect('accounts:password_reset')

    def post(self, request, token):
        try:
            profile = UserProfile.objects.get(password_reset_token=token)
            if profile.password_reset_token_expiry and timezone.now() > profile.password_reset_token_expiry:
                messages.error(request, 'Reset link has expired.')
                return redirect('accounts:password_reset')

            form = SetNewPasswordForm(request.POST)
            if form.is_valid():
                password = form.cleaned_data['password']
                user = profile.user
                user.set_password(password)
                user.save()

                profile.password_reset_token = None
                profile.password_reset_token_expiry = None
                profile.save()

                log_audit(user, 'PASSWORD_RESET_SUCCESS', get_client_ip(request), 'SUCCESS')
                messages.success(request, 'Password reset successful. Please log in.')
                return redirect('accounts:login')
            else:
                for field, errors in form.errors.items():
                    for error in errors:
                        messages.error(request, f"{field}: {error}")

            return render(request, self.template_name, {'form': form, 'token': token})
        except UserProfile.DoesNotExist:
            messages.error(request, 'Invalid reset link.')
            return redirect('accounts:password_reset')


class ChangePasswordView(View):
    """Allow logged-in user to change password."""
    template_name = 'accounts/change_password.html'

    @method_decorator(login_required)
    def get(self, request):
        return render(request, self.template_name)

    @method_decorator(login_required)
    def post(self, request):
        current_password = request.POST.get('current_password')
        new_password = request.POST.get('new_password')
        confirm_password = request.POST.get('confirm_password')

        if not request.user.check_password(current_password):
            messages.error(request, 'Current password is incorrect.')
            return render(request, self.template_name)

        if new_password != confirm_password:
            messages.error(request, 'New passwords do not match.')
            return render(request, self.template_name)

        if len(new_password) < 8:
            messages.error(request, 'Password must be at least 8 characters long.')
            return render(request, self.template_name)

        request.user.set_password(new_password)
        request.user.save()

        log_audit(request.user, 'PASSWORD_CHANGED', get_client_ip(request), 'SUCCESS')
        messages.success(request, 'Password changed successfully.')
        return redirect('accounts:dashboard')


class DashboardView(TemplateView):
    """Main dashboard - requires authentication."""
    template_name = 'accounts/dashboard.html'

    @method_decorator(login_required)
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['user_role'] = self.request.user.profile.get_role_display() if hasattr(self.request.user, 'profile') else 'Unknown'
        context['is_admin'] = is_admin(self.request.user)
        return context


class AdminDashboardView(TemplateView):
    """Admin-only dashboard."""
    template_name = 'accounts/admin_dashboard.html'

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['total_users'] = User.objects.count()
        context['active_users'] = UserProfile.objects.filter(is_active=True).count()
        context['locked_users'] = UserProfile.objects.filter(is_locked=True).count()
        context['recent_logins'] = AuditLog.objects.filter(action='LOGIN_SUCCESS').order_by('-timestamp')[:10]
        context['recent_audits'] = AuditLog.objects.all().order_by('-timestamp')[:20]
        return context


class UserManagementView(TemplateView):
    """Admin user management view."""
    template_name = 'accounts/user_management.html'

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['users'] = User.objects.all().select_related('profile__role')
        context['roles'] = UserRole.objects.all()
        return context


class UserDetailView(DetailView):
    """Admin view user details."""
    model = User
    template_name = 'accounts/user_detail.html'
    pk_url_kwarg = 'user_id'

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)


class UpdateUserRoleView(View):
    """Admin update user role."""

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def post(self, request, user_id):
        user = get_object_or_404(User, pk=user_id)
        role_id = request.POST.get('role_id')

        try:
            role = UserRole.objects.get(pk=role_id)
            user.profile.role = role
            user.profile.save()
            log_audit(request.user, f'ROLE_UPDATED_FOR_{user.username}', get_client_ip(request), 'SUCCESS')
            messages.success(request, f'Role updated for {user.username}.')
        except UserRole.DoesNotExist:
            messages.error(request, 'Invalid role.')

        return redirect('accounts:user_management')


class LockUnlockUserView(View):
    """Admin lock/unlock user accounts."""

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def post(self, request, user_id):
        user = get_object_or_404(User, pk=user_id)
        action = request.POST.get('action')

        if action == 'lock':
            user.profile.is_locked = True
            user.profile.locked_until = timezone.now() + timedelta(hours=24)
            log_audit(request.user, f'USER_LOCKED_{user.username}', get_client_ip(request), 'SUCCESS')
            messages.success(request, f'User {user.username} locked.')
        elif action == 'unlock':
            user.profile.is_locked = False
            user.profile.locked_until = None
            log_audit(request.user, f'USER_UNLOCKED_{user.username}', get_client_ip(request), 'SUCCESS')
            messages.success(request, f'User {user.username} unlocked.')

        user.profile.save()
        return redirect('accounts:user_detail', user_id=user_id)


class AuditLogView(TemplateView):
    """Admin view audit logs."""
    template_name = 'accounts/audit_logs.html'

    @method_decorator(login_required)
    @method_decorator(user_passes_test(is_admin))
    def dispatch(self, *args, **kwargs):
        return super().dispatch(*args, **kwargs)

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['audit_logs'] = AuditLog.objects.all().order_by('-timestamp')[:100]
        return context
