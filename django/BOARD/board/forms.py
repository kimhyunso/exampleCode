from django import forms
from .models import Board

class BoardForm(forms.ModelForm):
    title = forms.CharField(min_length=10, max_length=100, required=True)
    writer = forms.CharField(min_length=5, max_length=30, required=True)
    class Meta:
        model = Board
        fields = ('content', 'title', 'writer')