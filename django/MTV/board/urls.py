from django.urls import path
from .views import Post_Board, Post_Replay

app_name = 'board'

urlpatterns = [
    path('', Post_Board.view, name='index'),
    path('create/', Post_Board.create, name='create'),
    path('make/', Post_Board.make, name='make'),
    path('<int:board_pk>/edit/', Post_Board.edit, name='edit'),
    path('<int:board_pk>/update/', Post_Board.update, name='update'),
    path('<int:board_pk>/detail/', Post_Board.detail, name='detail'),
    path('<int:board_pk>/delete/', Post_Board.delete, name='delete'),
    
]