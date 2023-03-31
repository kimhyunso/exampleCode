from django.db import models

# Create your models here.
class Board(models.Model):
    content = models.TextField()
    title = models.CharField(max_length=50)
    writer = models.CharField(max_length=50)
    create_at = models.DateField(auto_now_add=True)
    update_at = models.DateField(auto_now=True)

