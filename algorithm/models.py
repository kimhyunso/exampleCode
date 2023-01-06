from django.db import models

# Create your models here.

class Article(models.Model):
    # CharField => 짧은 str
    author = models.CharField(max_length=30)
    title = models.CharField(max_length=100)
    # TextField => 긴 str
    content = models.TextField()

article = Article()
