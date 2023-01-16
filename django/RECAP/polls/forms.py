from django import forms
from .models import Question, Reply

class QuestionForm(forms.ModelForm):
    title = forms.CharField(min_length=3, max_length=50)
    class Meta:
        model = Question
        fields = ('title', )

class ReplyForm(forms.ModelForm):
    content = forms.CharField(min_length=3, max_length=50)
    class Meta:
        model = Reply
        fields = ('content', )