from django.urls import path
from . import views

app_name = 'classroom'

urlpatterns = [
    path('', views.view, name='index'),
    path('create/', views.create, name='create'),
    
]