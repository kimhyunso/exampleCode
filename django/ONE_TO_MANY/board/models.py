from django.db import models
from django.conf import settings

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=100)
    content = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
    update_at = models.DateTimeField(auto_now=True)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE, related_name='boards')
    like_users = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name='like_boards')

class Comment(models.Model):
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE, related_name='comments')
    content = models.CharField(max_length=50)
    create_at = models.DateTimeField(auto_now_add=True)
    update_at = models.DateTimeField(auto_now=True)
    board = models.ForeignKey(Board, on_delete=models.CASCADE, related_name='comments')
    # board = models.ForeignKey(Board, on_delete=models.CASCADE, related_name='asdf')

MALE_FEMALE_CHOICES = [
    (1, 'MALE'), 
    (2, 'FEMALE'), 
]

class Board(models.Model):
    title = models.CharField(max_length=30)
    content = models.TextField()
    writer = models.CharField(max_length=10)
    create_at = models.DateField(auto_now=True)
    update_at = models.DateField(auto_now_add=False)
    gender = models.CharField(choices=MALE_FEMALE_CHOICES) 

class Board(models.Model):
	user = models.ForeignKey(Board, on_delete=models.CASCADE)

