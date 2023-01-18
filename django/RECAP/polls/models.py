from django.db import models
from django.conf import settings

# Create your models here.


class Question(models.Model):
    title = models.CharField(max_length=50)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)


class Reply(models.Model):
    content = models.CharField(max_length=50)
    vote_users = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name='vote_users')
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    question = models.ForeignKey(Question, on_delete=models.CASCADE, related_name='replies')
    def is_voted(self, user):
        return self.vote_users.filter(pk=user.pk).exists()


