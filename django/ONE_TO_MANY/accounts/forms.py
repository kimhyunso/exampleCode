from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth import get_user_model

User = get_user_model()

class CustomUserCreationForm(UserCreationForm):
    class Meta:
        model = User
        fields = ('username', )


class BoardForm(forms.ModelForm):
    title = forms.CharField(min_length=2, max_length=30)
    class Meta:
        model = Board
        # fields = '__all__'
        fields = ('title', 'content', )
        # exclude = ('user', )