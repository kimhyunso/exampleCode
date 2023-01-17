from django.db import models


FEMALE_MALE_CHOICES = (
        (1, 'FEMALE'),
        (2, 'MALE'),
)

# Create your models here.
class User(models.Model):
    user_id = models.CharField(max_length=10)
    user_passwd = models.CharField(max_length=50)


class UserInfo(models.Model):
    address = models.TextField()
    user_name = models.CharField(max_length=10)
    user_gender = models.IntegerField(max_length=1, choices=FEMALE_MALE_CHOICES)
    phone_num = models.CharField(max_length=8)
    user_age = models.IntegerField(max_length=100)

