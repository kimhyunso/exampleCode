from django.shortcuts import render
# Create your views here.


def hello(request):
    # Res => HTML render
    # render(1. request, 2. HTML, 3. 넘길 데이터[context])
    return render(request, 'review/hello.html')


def index(request):
    return render(request, 'review/index.html')
