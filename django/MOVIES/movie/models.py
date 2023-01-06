from django.db import models

# Create your models here.


class Article(models.Model):
    # CharField => 짧은 str
    openDt = models.CharField(max_length=30)
    showTime = models.CharField(max_length=100)
    # TextField => 긴 str

# article = Article()
# 클래스
# 1. models.py 작성
# 속성값을 가공한 시안을 만듬
# 2. python manage.py makemigrations <app_name>
# 데이터베이스에 구현해줌
# 3. python manage.py migrate <app_name>