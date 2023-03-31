from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm
from django.contrib.auth import login as auth_login, logout as auth_logout
from django.views.decorators.http import require_http_methods
from .forms import CustomUserCreationForm

@require_http_methods(['GET', 'POST'])
def login(request):
    if request.method == 'POST':
        # 다른 form과 인자 구성이 다름
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            user = form.get_user()
            auth_login(request, user)
            next = request.GET.get('next')
            return redirect(next or 'board:board_index')
    else:
        form = AuthenticationForm()
    context = {
        'form' : form,
    } 
    return render(request, 'accounts/login.html', context)

def logout(request):
    auth_logout(request)
    return redirect('board:board_index')

@require_http_methods(['GET', 'POST'])
def signup(request):
    if request.method == 'POST':
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            auth_login(request, user)
            return redirect('board:board_index')
    else:
        form = CustomUserCreationForm()

    context = {'form' : form}
    return render(request, 'accounts/signup.html', context)



