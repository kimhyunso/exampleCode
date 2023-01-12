from django import forms
from .models import Board, Comment

class BoardForm(forms.ModelForm):
    title = forms.CharField(min_length=2, max_length=30)
    class Meta:
        model = Board
        fields = '__all__'

class CommentForm(forms.ModelForm):
    class Meta:
        model = Comment
        # fields = '__all__'
        exclude = ('board', )