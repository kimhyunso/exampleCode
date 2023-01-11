from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_http_methods, require_safe
from .models import Student
from .forms import StudentForm

'''
    GET => /classroom/create/ => 작성할 html
    POST => /classroom/create/ => 데이터 받아서 저장

    PUT => /classroom/creat/
    DELETE => /classroom/create/
'''


# 아래 view 함수는 ~ HTTP method 만 받겠다
@require_http_methods(['GET', 'POST'])
def create(request):
    if request.method == 'POST':
        form = StudentForm(request.POST)
        if form.is_valid():
            student = form.save()
            return redirect('classroom:detail', student.pk)
    else:
        form = StudentForm()
        
    context = {
        'form' : form,
    }
    return render(request, 'classroom/form.html', context)

# DB에 영향이 있다(CUD) => not safe
# DB에 영향이 없다(R) => safe
@require_safe
def index(request):
    student = Student.objects.order_by('-gpa')
    context = {
        'students' : student,
    }
    return render(request, 'classroom/index.html', context)


@require_safe
def detail(request, student_pk):
    student = get_object_or_404(Student, pk=student_pk)
    context = {
        'student' : student,
    }
    return render(request, 'classroom/detail.html', context)


@require_http_methods(['POST'])
def delete(request, student_pk):
    student = get_object_or_404(Student, pk=student_pk)
    student.delete()
    return redirect('classroom:index')


@require_http_methods(['POST', 'GET'])
def update(request, student_pk):
    student = get_object_or_404(Student, pk=student_pk)
    if request.method == "POST":
        form = StudentForm(request.POST, instance=student)
        if form.is_valid():
            student = form.save()
            return redirect('classroom:detail', student.pk)
    else:
        form = StudentForm(instance=student)
    context = {
        'form' : form,
    }
    return render(request, 'classroom/form.html', context)