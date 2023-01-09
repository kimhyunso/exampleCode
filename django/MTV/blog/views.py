from django.shortcuts import render, redirect
from .models import Aricle


# 글 목록 화면 (Read)
def index(request):
    # 글 목록 조회
    context = {
        'lists' : Aricle.objects.all(),
    }
    return render(request, 'blog/index.html', context)


# 글 상세 화면 (Read)
def detail(request, article_id):
    context = {
        'article' : Aricle.objects.get(id=article_id),
    }
    return render(request, 'blog/detail.html', context)


# 글 쓰기 (Create)
def new(request):
    return render(request, 'blog/new.html')

# 글 실제 저장
def create(request):
    article = Aricle()
    article.title = request.POST['title']
    article.content = request.POST['content']
    article.writer = request.POST['writer']
    article.save()
    # 뭘 어떻게 할까
    # detail로 redirect 하자
    return redirect('blog:detail', article.id)
    # return redirect(f'/blog/{article.id}/')



# 글 삭제 ?? (Delete)

def delete(request, artice_id):
    if request.method == 'POST':
        article = Aricle.objects.get(id=artice_id)
        article.delete()
    return redirect('blog:index')


# 글 수정 화면 (Update)
def edit(request, artice_id):
    context = {
        'article' : Aricle.objects.get(id=artice_id),
    }
    return render(request, 'blog/edit.html', context)

# 글 실제 수정
def update(request, artice_id):
    # 기존 article 객체 조회(레코드 검색)
    article = Aricle.objects.get(id=artice_id)
    article.title = request.POST['title']
    article.content = request.POST['content']
    article.writer = request.POST['writer']
    article.save()
    # 뭘 어떻게 할까
    # detail로 redirect 하자
    return redirect('blog:detail', article.id)
    # return redirect(f'/blog/{article.id}/')
