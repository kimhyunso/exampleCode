from django.shortcuts import render, redirect, get_object_or_404
from .models import Aricle
from .forms import ArticleForm


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
        'article' : get_object_or_404(Aricle, id=article_id),
    }
    return render(request, 'blog/detail.html', context)


# 글 쓰기 (Create)
def new(request):
    article_form = ArticleForm()
    context = {
        'article_form' : article_form,
    }
    return render(request, 'blog/form_new.html', context)

# 글 실제 저장
def create(request):
    article_form = ArticleForm(request.POST)

    # validation (데이터 유효성 검사)
    # 넘어온 데이터가 유효하다면
    if article_form.is_valid():
        # 저장하고
        article = article_form.save()
        # 뭘 어떻게 할까
        # detail로 redirect 하자
        return redirect('blog:detail', article.id)
        # return redirect(f'/blog/{article.id}/')
    # 넘어온 데이터가 유효하지 않다면
    else:
        context = {
            'article_form' : article_form,
        }
        return render(request, 'blog/form_new.html', context)

# 글 삭제 ?? (Delete)
def delete(request, artice_id):
    if request.method == 'POST':
        article = Aricle.objects.get(id=artice_id)
        article.delete()
    return redirect('blog:index')


# 글 수정 화면 (Update)
def edit(request, artice_id):
    context = {
        'article' : get_object_or_404(Aricle, id=artice_id),
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
