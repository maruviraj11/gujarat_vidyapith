from django.db import models
from django.contrib.auth.models import User, Permission, Group
from django.core.validators import EmailValidator
from django.utils import timezone
from django.db.models.signals import post_save
from django.dispatch import receiver


class UserRole(models.Model):
    """Define user roles for RBAC."""
    ROLE_CHOICES = [
        ('ADMIN', 'Administrator'),
        ('USER', 'General User'),
        ('MODERATOR', 'Moderator'),
    ]
    
    name = models.CharField(max_length=50, choices=ROLE_CHOICES, unique=True)
    description = models.TextField(blank=True, null=True)
    permissions = models.ManyToManyField(Permission, blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name = 'User Role'
        verbose_name_plural = 'User Roles'
    
    def __str__(self):
        return self.get_name_display()


class UserProfile(models.Model):
    """Extended user profile with role and security information."""
    user = models.OneToOneField(User, on_delete=models.CASCADE, related_name='profile')
    role = models.ForeignKey(UserRole, on_delete=models.SET_NULL, null=True, blank=True)
    phone_number = models.CharField(max_length=15, blank=True, null=True)
    is_active = models.BooleanField(default=True)
    is_verified = models.BooleanField(default=False)
    last_login_ip = models.GenericIPAddressField(null=True, blank=True)
    login_attempts = models.IntegerField(default=0)
    last_failed_attempt = models.DateTimeField(null=True, blank=True)
    is_locked = models.BooleanField(default=False)
    locked_until = models.DateTimeField(null=True, blank=True)
    password_reset_token = models.CharField(max_length=255, blank=True, null=True)
    password_reset_token_expiry = models.DateTimeField(null=True, blank=True)
    two_factor_enabled = models.BooleanField(default=False)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    
    class Meta:
        verbose_name = 'User Profile'
        verbose_name_plural = 'User Profiles'
    
    def __str__(self):
        return f"{self.user.username} - {self.get_role_display()}"
    
    def get_role_display(self):
        return self.role.get_name_display() if self.role else 'No Role'
    
    def is_account_locked(self):
        """Check if account is locked and if lock has expired."""
        if self.is_locked:
            if self.locked_until and timezone.now() > self.locked_until:
                self.is_locked = False
                self.locked_until = None
                self.save()
                return False
            return True
        return False
    
    def has_permission(self, permission_codename):
        """Check if user has specific permission."""
        if not self.role:
            return False
        return self.role.permissions.filter(codename=permission_codename).exists()


class AuditLog(models.Model):
    """Track user activities for security auditing."""
    user = models.ForeignKey(User, on_delete=models.SET_NULL, null=True, blank=True)
    action = models.CharField(max_length=255)
    description = models.TextField(blank=True, null=True)
    ip_address = models.GenericIPAddressField()
    user_agent = models.TextField(blank=True, null=True)
    status = models.CharField(
        max_length=20,
        choices=[('SUCCESS', 'Success'), ('FAILURE', 'Failure')],
        default='SUCCESS'
    )
    timestamp = models.DateTimeField(auto_now_add=True)
    
    class Meta:
        verbose_name = 'Audit Log'
        verbose_name_plural = 'Audit Logs'
        ordering = ['-timestamp']
    
    def __str__(self):
        return f"{self.user} - {self.action} - {self.timestamp}"


@receiver(post_save, sender=User)
def create_user_profile(sender, instance, created, **kwargs):
    """Create UserProfile when User is created."""
    if created:
        UserProfile.objects.get_or_create(user=instance)


@receiver(post_save, sender=User)
def save_user_profile(sender, instance, **kwargs):
    """Save UserProfile when User is saved."""
    instance.profile.save()
