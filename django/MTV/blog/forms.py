from django import forms
from .models import Aricle

class ArticleForm(forms.ModelForm):
    # 1. 유효성검사 (Validation)
    # 2. HTML안에 <input> 태그 만들기 귀찬
    # 3. 저장할 때 request.POST 에서 하나하나 꺼내기 귀찬
    title = forms.CharField(min_length=2, max_length=100)
    writer = forms.CharField(min_length=2, max_length=30)
    
    class Meta:
        model = Aricle
        fields = ('title', 'content', 'writer',)