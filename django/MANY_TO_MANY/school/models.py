from django.db import models

# Create your models here.
class Lecture(models.Model):
    title = models.CharField(max_length=100)
    room = models.CharField(max_length=30)
    def __str__(self):
        return f'#{self.pk}: {self.title}'

class Student(models.Model):
    name = models.CharField(max_length=50)
    major = models.CharField(max_length=50)
    # m:n 관계의 상대모델 커스텀 Join 테이블 => through
    lectures = models.ManyToManyField(Lecture, related_name='students', through='school.Enrollment', through_fields=('student', 'lecture'))
    def __str__(self):
        return f'#{self.pk}: {self.name}'

# Join Table에 추가 데이터가 있다면, 클래스 생성
class Enrollment(models.Model):
    grade = models.CharField(max_length=2)
    semester = models.CharField(max_length=20)
    lecture = models.ForeignKey(Lecture, on_delete=models.CASCADE)
    student = models.ForeignKey(Student, on_delete=models.CASCADE)
    major = models.CharField(max_length=5)
    models.TextField
    def __str__(self):
        return f'#{self.lecture} <=> {self.student}'

    

'''
s1 = Student.objects.create(name='test', major='SOC')
s2 = Student.objects.create(name='qwer', major='PSY')
s3 = Student.objects.create(name='alex', major='CSE')
s4 = Student.objects.create(name='kyle', major='MCH')

l1 = Lecture.objects.create(title='파이썬기초', room='1001')
l2 = Lecture.objects.create(title='결혼특강', room='231')    
l3 = Lecture.objects.create(title='심리학개론', room='B101') 
l4 = Lecture.objects.create(title='무기화학', room='1301')   

# 자동으로 Enrollment의 객체가 생성됨(비권장)
s1.lectures.add(l1)
# 방금 생성된 Enrollment 객체 조회
e1 = Enrollment.objects.get(student=s1, lecture=l1)
e1.student == s1
e1.lecture == l1

# 자동 생성시 비어있는 항목들
e1.grade == ''
e1.semester == ''

e1.grade = 'B+'
e1.semester = '2023-1'  
e1.save()
# 수강신청을 새로 생성
e2 = Enrollment() 
e2.student = s1
e2.lecture = l2
e2.grade = 'C+'
e2.semester = '2023-1'  
e2.save()

# s1의 모든 수업
s1.lectures.all()
# l2의 모든 수강생
l2.students.all()

'''