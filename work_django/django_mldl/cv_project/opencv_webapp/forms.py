from django import forms

class SimpleUploadForm(forms.Form):
    title = forms.CharField(max_length=50)
    # ImageField Inherits all attributes and methods FileField, but also validates that the uploaded object is a validation
    # file = forms.FileField()
    image = forms.ImageField()
