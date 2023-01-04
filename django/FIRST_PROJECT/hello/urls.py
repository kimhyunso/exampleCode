from django.urls import path
from . import views

urlpatterns = [
    path('world/', views.hello_world),
    path('lunch/',views.lunch),
    path('lotto/',views.lotto),
]