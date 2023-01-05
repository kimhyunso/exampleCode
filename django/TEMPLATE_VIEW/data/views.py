from django.shortcuts import render

# Create your views here.


def hello(request, name):
    context = {
        'name' : name,
    }
    return render(request, 'data/hello.html', context)

def index(request):
    return render(request, 'data/index.html')

def user_input(request):
    return render(request, 'data/user_input.html')

def user_output(request):
    c = request.POST['cel']
    f = int(c) * 1.8 + 32

    context = {
        'username' : request.POST['username'],
        'password' : request.POST['password'],
        'f' : f,
    }
    return render(request, 'data/user_output.html', context)
