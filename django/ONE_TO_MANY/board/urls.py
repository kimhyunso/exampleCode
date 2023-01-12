from django.urls import path
from . import views

app_name = 'board'

BoardViews = views.BoardViews
CommentViews = views.CommentViews

urlpatterns = [
    path('', BoardViews.index, name='board_index'),
    path('create/', BoardViews.create, name='board_create'),
    path('<int:board_pk>/', BoardViews.detail, name='board_detail'),
    path('<int:board_pk>/comments/create/', CommentViews.create, name='comment_create'),
    path('<int:board_pk>/comments/<int:comment_pk>/delete/', CommentViews.delete, name='comment_delete'),
]