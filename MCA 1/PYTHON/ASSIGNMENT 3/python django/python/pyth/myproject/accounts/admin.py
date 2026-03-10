from django.contrib import admin
from .models import UserRole, UserProfile, AuditLog


@admin.register(UserRole)
class UserRoleAdmin(admin.ModelAdmin):
    """Admin for UserRole model."""
    list_display = ('name', 'description', 'created_at')
    filter_horizontal = ('permissions',)
    search_fields = ('name',)
    ordering = ('-created_at',)


@admin.register(UserProfile)
class UserProfileAdmin(admin.ModelAdmin):
    """Admin for UserProfile model."""
    list_display = (
        'user',
        'role',
        'is_active',
        'is_verified',
        'is_locked',
        'login_attempts',
        'created_at'
    )
    list_filter = ('is_active', 'is_verified', 'is_locked', 'role')
    search_fields = ('user__username', 'user__email', 'phone_number')
    readonly_fields = ('created_at', 'updated_at', 'last_login_ip', 'last_failed_attempt')
    
    fieldsets = (
        ('User Information', {
            'fields': ('user', 'role', 'phone_number')
        }),
        ('Account Status', {
            'fields': ('is_active', 'is_verified')
        }),
        ('Security', {
            'fields': (
                'is_locked',
                'locked_until',
                'login_attempts',
                'last_failed_attempt',
                'last_login_ip'
            ),
            'classes': ('collapse',)
        }),
        ('Password Reset', {
            'fields': (
                'password_reset_token',
                'password_reset_token_expiry'
            ),
            'classes': ('collapse',)
        }),
        ('Two-Factor Authentication', {
            'fields': ('two_factor_enabled',)
        }),
        ('Timestamps', {
            'fields': ('created_at', 'updated_at'),
            'classes': ('collapse',)
        })
    )
    
    def get_readonly_fields(self, request, obj=None):
        """Make certain fields read-only."""
        if obj:
            return self.readonly_fields + ['user']
        return self.readonly_fields


@admin.register(AuditLog)
class AuditLogAdmin(admin.ModelAdmin):
    """Admin for AuditLog model."""
    list_display = (
        'user',
        'action',
        'status',
        'ip_address',
        'timestamp'
    )
    list_filter = ('status', 'action', 'timestamp')
    search_fields = ('user__username', 'user__email', 'ip_address', 'action')
    readonly_fields = (
        'user',
        'action',
        'description',
        'ip_address',
        'user_agent',
        'status',
        'timestamp'
    )
    ordering = ('-timestamp',)
    
    def has_add_permission(self, request):
        """Prevent manual creation of audit logs."""
        return False
    
    def has_delete_permission(self, request, obj=None):
        """Prevent deletion of audit logs."""
        return False
