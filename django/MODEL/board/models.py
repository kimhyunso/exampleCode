from django.db import models

# Create your models here.

class Article(models.Model):
    # CharField => 짧은 str
    author = models.CharField(max_length=30)
    title = models.CharField(max_length=100)
    # TextField => 긴 str
    content = models.TextField()
    ttt = models.IntegerField(default=3)

article = Article()
# 1. models.py 작성
# 2. python manage.py makemigrations <app_name>
# 3. python manage.py migrate <app_name>