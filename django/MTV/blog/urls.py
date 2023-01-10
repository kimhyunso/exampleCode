from django.urls import path
from . import views

app_name = 'blog'

urlpatterns = [
    path('', views.index, name='index'),
    # blog/1/
    path('<int:article_id>/', views.detail, name='detail'),

    # blog/new/
    path('new/', views.new, name='new'),
    # blog/create/
    path('create/', views.create, name='create'),
    
    # blog/delete/
    path('<int:article_id>/delete/', views.delete, name='delete'),

    # blog/1/edit/
    path('<int:article_id>/edit/', views.edit, name='edit'),
    # blog/1/update/
    path('<int:article_id>/update/', views.update, name='update'),
]

"""
def path(url, function_name, name):
    'url을 잘 만져서, article_id'

    function_name()
"""


"""
URL => 내맘
1. Resource를 표현
2. 명사형
3. 확실히 구분
4. 동사는 빼라
"""