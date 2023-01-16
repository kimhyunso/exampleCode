from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponseBadRequest
from django.views.decorators.http import require_http_methods
from django.contrib.auth import login as user_login, logout as user_logout
from django.contrib.auth.forms import AuthenticationForm
from .models import User
from .forms import CustomUserCreationForm

HOME_URL = 'polls:question_index'

@require_http_methods(['POST', 'GET'])
def signup(request):
    if request.user.is_authenticated:
        return HttpResponseBadRequest('이미 로그인 하였습니다.')

    if request.method == 'POST':
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            user_login(request, user)
            return redirect(HOME_URL)
    else:
        form = CustomUserCreationForm()

    context = {
        'form' : form,
    }
    return render(request, 'accounts/signup.html', context)

@require_http_methods(['POST', 'GET'])
def login(request):
    if request.user.is_authenticated:
        return HttpResponseBadRequest('이미 로그인 하였습니다.')

    if request.method == 'POST':
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            # AuthenticationForm => User create가 아님 다른 메서드 제공
            user_login(request, form.get_user())
            return redirect(HOME_URL)
    else:
        form = AuthenticationForm()

    context = {
        'form' : form,
    }
    return render(request, 'accounts/login.html', context)

    
def logout(request):
    user_logout(request)
    return redirect(HOME_URL)