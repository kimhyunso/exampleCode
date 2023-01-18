from django.db import models
from django.contrib.auth.models import AbstractUser
# Create your models here.

class User(AbstractUser):
    # symmetrical => 데이터값이 대칭으로 들어간다.
    # 1, 2이 들어가면 2, 1도 들어감
    stars = models.ManyToManyField('self', symmetrical=False, related_name='fans')
    MBTI_CHOICES = (
        ('INTJ', 'INTJ'),
        ('INTP', 'INTP'),
        ('ISTP', 'ISTP'),
        ('ISFP', 'ISFP'),
        ('ENTJ', 'ENTJ'),
        ('ENTP', 'ENTP'),
        ('INFJ', 'INFJ'),
        ('INFP', 'INFP'),
        ('ENFJ', 'ENFJ'),
        ('ENFP', 'ENFP'),
        ('ISTJ', 'ISTJ'),
        ('ISFJ', 'ISFJ'),
        ('ESTJ', 'ESTJ'),
        ('ESTP', 'ESTP'),
        ('ESFP', 'ESFP'),
    )
    mbti = models.CharField(max_length=4, choices=MBTI_CHOICES)
'''
u2.fans.filter(mbti__contains='ENT')
'''