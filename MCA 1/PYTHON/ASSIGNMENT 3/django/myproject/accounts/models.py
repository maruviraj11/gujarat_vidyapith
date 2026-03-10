from django.db import models

# Create your models here.
# accounts/models.py
from django.contrib.auth.models import AbstractUser
from django.db import models

class User(AbstractUser):
    # add extra fields later if needed, e.g. phone, is_email_verified
    phone = models.CharField(max_length=20, blank=True, null=True)
    # convenience property for role-checking
    @property
    def is_admin_user(self):
        return self.is_staff or self.groups.filter(name='Admin').exists()
