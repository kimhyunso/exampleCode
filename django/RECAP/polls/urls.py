from django.urls import path
from . import views

app_name = 'polls'

Question = views.Questiones
Comment = views.Comment

urlpatterns = [
    path('', Question.index, name='question_index'),
    path('create/', Question.create, name='question_create'),
    path('<int:question_pk>/', Question.detail, name='question_detail'),
    path('<int:question_pk>/update/', Question.update, name='question_update'),
    path('<int:question_pk>/delete/', Question.delete, name='question_delete'),
    path('<int:question_pk>/replies/create/', Comment.create, name='reply_create'),
    path('<int:question_pk>/replies/<int:reply_pk>/delete/', Comment.delete, name='reply_delete'),
    path('<int:question_pk>/replies/<int:reply_pk>/vote/', Comment.vote_reply, name='vote_reply'),
]