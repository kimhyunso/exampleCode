from django.db import models

# Create your models here.
class Aricle(models.Model):
    title = models.CharField(max_length=200)
    content = models.TextField()
    # 생성시 자동으로 채워지도록
    create_at = models.DateTimeField(auto_now_add=True)
    # 생성/수정시 자동으로 채워지도록
    updated_at = models.DateTimeField(auto_now=True)
    writer = models.CharField(max_length=30)
