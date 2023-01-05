from django.urls import path
from . import views

app_name = 'data'

urlpatterns = [
    # data/
    path('', views.index, name='index'),
    # data/input/
    path('user_input/', views.user_input, name='user_input'),
    # data/hello/<name>/ => Variable Routing
    # hello/neo/ => 안녕 neo,
    # hello/andy/ => 안녕 andy,
    # data/hello/
    path('hello/', views.hello, name='hello'),
    path('hello/<str:name>/', views.hello, name='name'),
    path('user_output/', views.user_output, name='user_output'),
]
