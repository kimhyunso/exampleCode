from django.shortcuts import render, redirect
from .models import Aricle
from .forms import ArticleForm


def new(request):
    if request.method == 'POST':
        article_form = ArticleForm(request.POST)
        if article_form.is_valid():
            article = article_form.save()
            return redirect('blog:detail', article.id)
    elif request.method == 'GET':
        article_form = ArticleForm()
            
    context = {
        'article_form' : article_form,
    }
    return render(request, 'blog/form_new.html', context)
