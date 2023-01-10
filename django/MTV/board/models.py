from django.db import models

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=50)
    content = models.TextField()
    writer = models.CharField(max_length=50)
    create_date = models.DateField(auto_now_add=True)
    update_date = models.DateField(auto_now=True)

class Replay(models.Model):
    content = models.TextField()
    writer = models.CharField(max_length=30)
    create_date = models.DateField(auto_now_add=True)
    update_date = models.DateField(auto_now=True)

