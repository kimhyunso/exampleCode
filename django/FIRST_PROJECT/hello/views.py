from django.shortcuts import render
from django.http.response import HttpResponse as res
import random as r

# Create your views here.
# def hihihi(request):
#     return res(r.sample(range(1, 46), 6))

def hello_world(request):
    # 응답으로 HTML을 렌더링 하겠다.
    # django => 무조건 HTML 파일은 templates/ 에서 찾는다.
    return render(request, 'hello_world.html')

def lunch(request):
    menus = ['짜장', '치킨', '삼겹살', '샐러드', '보쌈', '샐러드', '국밥',]
    menu = r.choice(menus)
    context = {
        'menu' : menu,
    }
    return render(request, 'lunch.html', context)

def lotto(request):
    lottos = r.sample(range(1, 46), 6)
    lottos.sort()
    context = {
        'lottos' : lottos,
        'is_jackpot' : True,
    }
    return render(request, 'lotto.html', context)

# def goodbye_world(request):
#     pass

