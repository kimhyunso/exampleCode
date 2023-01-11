from django.urls import path
from . import views

app_name = 'board'

urlpatterns = [
    path('', views.board_index, name='board_index'),
    path('create/', views.board_create, name='board_create'),
    path('<int:board_pk>/detail/', views.board_detail, name='board_detail'),
    path('<int:board_pk>/update/', views.board_update, name='board_update'),
    path('<int:board_pk>/delete/', views.board_delete, name='board_delete'),
]
