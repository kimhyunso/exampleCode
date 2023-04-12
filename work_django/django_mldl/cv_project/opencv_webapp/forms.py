from django import forms
from .models import ImageUploadModel

class SimpleUploadForm(forms.Form):
    title = forms.CharField(max_length=50)
    # ImageField Inherits all attributes and methods FileField, but also validates that the uploaded object is a validation
    # file = forms.FileField()
    image = forms.ImageField()


class ImageUploadForm(forms.ModelForm):
    class Meta:
        model = ImageUploadModel
        # Form을 통해 사용자로부터 입력 받으려는 Model Class의 field 리스트
        fields = ('description', 'document',) # uploaded_at

        



