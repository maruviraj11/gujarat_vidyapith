from django.core.management.base import BaseCommand
from django.contrib.auth.models import Permission
from accounts.models import UserRole


class Command(BaseCommand):
    """Management command to initialize user roles and permissions."""
    help = 'Initialize user roles and assign permissions'
    
    def handle(self, *args, **options):
        self.stdout.write(self.style.SUCCESS('Initializing user roles and permissions...'))
        
        # Get all permissions
        all_permissions = Permission.objects.all()
        view_permissions = all_permissions.filter(codename__startswith='view_')
        add_permissions = all_permissions.filter(codename__startswith='add_')
        change_permissions = all_permissions.filter(codename__startswith='change_')
        delete_permissions = all_permissions.filter(codename__startswith='delete_')
        
        # Create Admin Role
        admin_role, admin_created = UserRole.objects.get_or_create(
            name='ADMIN',
            defaults={
                'description': 'Administrator with full access to all resources'
            }
        )
        if admin_created:
            admin_role.permissions.set(all_permissions)
            self.stdout.write(self.style.SUCCESS(f'Created ADMIN role with all permissions'))
        else:
            self.stdout.write(self.style.WARNING('ADMIN role already exists'))
        
        # Create User Role
        user_role, user_created = UserRole.objects.get_or_create(
            name='USER',
            defaults={
                'description': 'General user with limited access'
            }
        )
        if user_created:
            user_role.permissions.set(view_permissions)
            self.stdout.write(self.style.SUCCESS(f'Created USER role'))
        else:
            self.stdout.write(self.style.WARNING('USER role already exists'))
        
        # Create Moderator Role
        moderator_role, moderator_created = UserRole.objects.get_or_create(
            name='MODERATOR',
            defaults={
                'description': 'Moderator with enhanced permissions'
            }
        )
        if moderator_created:
            moderate_permissions = list(view_permissions) + list(add_permissions) + list(change_permissions)
            moderator_role.permissions.set(moderate_permissions)
            self.stdout.write(self.style.SUCCESS(f'Created MODERATOR role'))
        else:
            self.stdout.write(self.style.WARNING('MODERATOR role already exists'))
        
        self.stdout.write(self.style.SUCCESS('Role initialization completed successfully!'))
