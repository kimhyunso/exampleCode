from django import forms
from .models import Board, Comment

class BoardForm(forms.ModelForm):
    title = forms.CharField(min_length=2, max_length=30)
    class Meta:
        model = Board
        # fields = '__all__'
        exclude = ('user', )

class CommentForm(forms.ModelForm):
    content = forms.CharField(min_length=2, max_length=200, widget=forms.TextInput(attrs={'autofocus':True,}))
    class Meta:
        model = Comment
        # fields = '__all__'
        exclude = ('board', 'user', )