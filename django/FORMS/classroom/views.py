from django.shortcuts import render, redirect, get_object_or_404
from .models import Student
from .forms import StudentForm

'''
    GET => /classroom/create/ => 작성할 html
    POST => /classroom/create/ => 데이터 받아서 저장
'''

def create(request):
    if request.method == 'POST':
        form = StudentForm(request.POST)
        if form.is_valid():
            student = form.save()
            return redirect('classroom:detail')
    else:
        form = StudentForm()
        
    context = {
        'form' : form,
    }
    return render(request, 'classroom/new.html', context)

def edit(request):
    pass

def delete(request):
    pass

def view(request):
    return render(request, 'classroom/index.html')