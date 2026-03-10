from django.urls import path
from . import views

app_name = 'accounts'

urlpatterns = [
    # Authentication URLs
    path('register/', views.RegisterView.as_view(), name='register'),
    path('login/', views.LoginView.as_view(), name='login'),
    path('logout/', views.LogoutView.as_view(), name='logout'),
    
    # Password Management URLs
    path('password-reset/', views.PasswordResetView.as_view(), name='password_reset'),
    path('password-reset-confirm/<str:token>/', views.PasswordResetConfirmView.as_view(), name='password_reset_confirm'),
    path('change-password/', views.ChangePasswordView.as_view(), name='change_password'),
    
    # Dashboard URLs
    path('dashboard/', views.DashboardView.as_view(), name='dashboard'),
    path('admin-dashboard/', views.AdminDashboardView.as_view(), name='admin_dashboard'),
    
    # User Management URLs (Admin)
    path('users/', views.UserManagementView.as_view(), name='user_management'),
    path('users/<int:user_id>/', views.UserDetailView.as_view(), name='user_detail'),
    path('users/<int:user_id>/role/', views.UpdateUserRoleView.as_view(), name='update_user_role'),
    path('users/<int:user_id>/lock/', views.LockUnlockUserView.as_view(), name='lock_unlock_user'),
    
    # Audit Log URLs (Admin)
    path('audit-logs/', views.AuditLogView.as_view(), name='audit_logs'),
]
