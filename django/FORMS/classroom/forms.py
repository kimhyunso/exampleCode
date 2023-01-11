from django import forms
from .models import Student

class StudentForm(forms.ModelForm):
    name = forms.CharField(min_length=2, max_length=10)
    age = forms.IntegerField(min_value=10, max_value=100)
    gpa = forms.FloatField(min_value=0.0, max_value=4.5)
    major = forms.CharField(min_length=2, max_length=20)
    # 이 클래스의 메타 데이터 저장용
    class Meta:
        model = Student
        fields = '__all__'
        # fields = ('name', 'age', 'gpa', 'major', )
