from django.urls import path
from . import views

app_name = 'classroom'

urlpatterns = [
    path('', views.index, name='index'),
    path('create/', views.create, name='create'),
    path('<int:student_pk>/', views.detail, name='detail'),
    path('<int:student_pk>/delete/', views.delete, name='delete'),
    path('<int:student_pk>/update/', views.update, name='update'),
]