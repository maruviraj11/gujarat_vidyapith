from django.contrib.auth.decorators import user_passes_test
from django.core.exceptions import PermissionDenied
from django.http import HttpResponseForbidden
from django.shortcuts import redirect
from functools import wraps


def role_required(role_name):
    """Decorator to restrict view access by role."""
    def decorator(view_func):
        @wraps(view_func)
        def wrapper(request, *args, **kwargs):
            if not request.user.is_authenticated:
                return redirect('login')
            
            if not hasattr(request.user, 'profile'):
                return HttpResponseForbidden('No profile found.')
            
            user_role = request.user.profile.role
            if not user_role or user_role.name != role_name:
                return HttpResponseForbidden('You do not have permission to access this resource.')
            
            return view_func(request, *args, **kwargs)
        return wrapper
    return decorator


def permission_required(permission_codename):
    """Decorator to restrict view access by specific permission."""
    def decorator(view_func):
        @wraps(view_func)
        def wrapper(request, *args, **kwargs):
            if not request.user.is_authenticated:
                return redirect('login')
            
            if not hasattr(request.user, 'profile'):
                return HttpResponseForbidden('No profile found.')
            
            if not request.user.profile.has_permission(permission_codename):
                return HttpResponseForbidden('You do not have permission to perform this action.')
            
            return view_func(request, *args, **kwargs)
        return wrapper
    return decorator


def admin_required(view_func):
    """Decorator to restrict view to admin users only."""
    @wraps(view_func)
    def wrapper(request, *args, **kwargs):
        if not request.user.is_authenticated:
            return redirect('login')
        
        if not hasattr(request.user, 'profile'):
            return HttpResponseForbidden('No profile found.')
        
        if not request.user.profile.role or request.user.profile.role.name != 'ADMIN':
            return HttpResponseForbidden('Admin access required.')
        
        return view_func(request, *args, **kwargs)
    return wrapper


def verified_required(view_func):
    """Decorator to ensure user email is verified."""
    @wraps(view_func)
    def wrapper(request, *args, **kwargs):
        if not request.user.is_authenticated:
            return redirect('login')
        
        if not hasattr(request.user, 'profile') or not request.user.profile.is_verified:
            return HttpResponseForbidden('Email verification required.')
        
        return view_func(request, *args, **kwargs)
    return wrapper


def active_required(view_func):
    """Decorator to ensure user account is active."""
    @wraps(view_func)
    def wrapper(request, *args, **kwargs):
        if not request.user.is_authenticated:
            return redirect('login')
        
        if not hasattr(request.user, 'profile') or not request.user.profile.is_active:
            return HttpResponseForbidden('Your account is inactive.')
        
        return view_func(request, *args, **kwargs)
    return wrapper


def not_locked_required(view_func):
    """Decorator to ensure account is not locked."""
    @wraps(view_func)
    def wrapper(request, *args, **kwargs):
        if not request.user.is_authenticated:
            return redirect('login')
        
        if hasattr(request.user, 'profile') and request.user.profile.is_account_locked():
            return HttpResponseForbidden('Your account is temporarily locked.')
        
        return view_func(request, *args, **kwargs)
    return wrapper


def moderator_or_admin_required(view_func):
    """Decorator to restrict view to moderators and admins."""
    @wraps(view_func)
    def wrapper(request, *args, **kwargs):
        if not request.user.is_authenticated:
            return redirect('login')
        
        if not hasattr(request.user, 'profile'):
            return HttpResponseForbidden('No profile found.')
        
        allowed_roles = ['ADMIN', 'MODERATOR']
        if not request.user.profile.role or request.user.profile.role.name not in allowed_roles:
            return HttpResponseForbidden('Moderator or Admin access required.')
        
        return view_func(request, *args, **kwargs)
    return wrapper
