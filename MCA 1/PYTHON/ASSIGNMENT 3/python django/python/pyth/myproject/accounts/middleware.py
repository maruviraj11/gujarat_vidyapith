from django.utils.deprecation import MiddlewareMixin
from django.http import HttpResponseForbidden
from .models import AuditLog
import logging

logger = logging.getLogger(__name__)


class SecurityMiddleware(MiddlewareMixin):
    """Enhanced security middleware for the application."""
    
    SENSITIVE_PATHS = ['/admin/', '/accounts/users/', '/accounts/audit-logs/']
    
    def get_client_ip(self, request):
        """Extract client IP from request."""
        x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
        if x_forwarded_for:
            ip = x_forwarded_for.split(',')[0]
        else:
            ip = request.META.get('REMOTE_ADDR')
        return ip
    
    def process_request(self, request):
        """Log and validate incoming requests."""
        # Store IP and user agent in request for later use
        request.client_ip = self.get_client_ip(request)
        request.user_agent = request.META.get('HTTP_USER_AGENT', '')
        
        # Log access to sensitive paths
        if any(request.path.startswith(path) for path in self.SENSITIVE_PATHS):
            if not request.user.is_authenticated or not self.is_admin(request.user):
                logger.warning(f"Unauthorized access attempt to {request.path} from {request.client_ip}")
        
        return None
    
    def process_response(self, request, response):
        """Add security headers to response."""
        # Add security headers
        response['X-Content-Type-Options'] = 'nosniff'
        response['X-Frame-Options'] = 'DENY'
        response['X-XSS-Protection'] = '1; mode=block'
        response['Referrer-Policy'] = 'strict-origin-when-cross-origin'
        
        return response
    
    def is_admin(self, user):
        """Check if user is admin."""
        return hasattr(user, 'profile') and user.profile.role and user.profile.role.name == 'ADMIN'


class AuditLoggingMiddleware(MiddlewareMixin):
    """Middleware to log authentication-related activities."""
    
    LOGGED_PATHS = [
        ('/accounts/login/', 'LOGIN_ATTEMPT'),
        ('/accounts/logout/', 'LOGOUT'),
        ('/accounts/register/', 'REGISTRATION'),
        ('/accounts/password-reset/', 'PASSWORD_RESET_REQUEST'),
    ]
    
    def get_client_ip(self, request):
        """Extract client IP from request."""
        x_forwarded_for = request.META.get('HTTP_X_FORWARDED_FOR')
        if x_forwarded_for:
            ip = x_forwarded_for.split(',')[0]
        else:
            ip = request.META.get('REMOTE_ADDR')
        return ip
    
    def process_response(self, request, response):
        """Log authentication activities."""
        # Log specific authentication paths
        for path, action in self.LOGGED_PATHS:
            if request.path == path and request.method == 'POST':
                status = 'SUCCESS' if response.status_code < 400 else 'FAILURE'
                user = request.user if request.user.is_authenticated else None
                
                AuditLog.objects.create(
                    user=user,
                    action=action,
                    ip_address=self.get_client_ip(request),
                    user_agent=request.META.get('HTTP_USER_AGENT', ''),
                    status=status
                )
        
        return response


class SessionSecurityMiddleware(MiddlewareMixin):
    """Middleware for enhanced session security."""
    
    def process_request(self, request):
        """Validate session and user state."""
        if request.user.is_authenticated:
            # Check if user is still active
            if not request.user.is_active:
                from django.contrib.auth import logout
                logout(request)
                return None
            
            # Check if user account is locked
            if hasattr(request.user, 'profile') and request.user.profile.is_account_locked():
                from django.contrib.auth import logout
                logout(request)
                return None
        
        return None
