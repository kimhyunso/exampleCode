from django.shortcuts import render, redirect, get_object_or_404
from django.http import HttpResponseBadRequest
from django.views.decorators.http import require_http_methods, require_safe
from django.contrib.auth import login as user_login, logout as user_logout, get_user_model
from django.contrib.auth.forms import AuthenticationForm
from .forms import CustomUserCreationForm

User = get_user_model()

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

# 1. 어디서 팔로우 관리를 할까? => Profile Page
# 2. 실제 팔로우 기능
# /accounts/<user_name>/follow/
@require_http_methods(['POST', 'GET'])
def follow(request, username):
    me = request.user
    you = get_object_or_404(User, username=username)
    if request.method == 'POST':
        if me == you:
            return HttpResponseBadRequest('자기 자신 팔로우 불가능')
        is_following = me.stars.filter(pk=you.pk).exists()
        if is_following:
            me.stars.remove(you)
        else:
            me.stars.add(you)
        #TODO: Profile 페이지 만들고, redirect로 보내기
        return redirect('accounts:profile', you.username)
    else:
        E_count = you.fans.filter(mbti__istartswith='E').count()
        I_count = you.fans.filter(mbti__istartswith='I').count()
        if me.is_authenticated:
            is_following = me.stars.filter(pk=you.pk).exists()
            # 나를 팔로워한 사람의 MBTI의 별로 카운터를 새거나
            # 나를 팔로워한 사람중에 E의 카운트, I의 카운트
        else:
            is_following = None

        context = {
            'profile_user' : you,
            'is_following' : is_following,
            'E_count' : E_count,
            'I_count' : I_count,
        }
        return render(request, 'accounts/profile.html', context)


# TODO : 1. 게시글 작성자 이름 클릭 => 프로필
# TODO : 2. 댓글 작성자 이름 표시 => 클릭 => 프로필
# TODO : 3. 프로필 페이지에서 좀 더 많은 정보 보여주기 (프로필의 팔로워의 MBTI 분포도 등등....)
