from django.shortcuts import render, redirect, get_object_or_404
from .models import Question, Reply
from django.contrib.auth.decorators import login_required
from .forms import QuestionForm, ReplyForm
from django.views.decorators.http import require_http_methods, require_safe
from django.http import HttpResponseForbidden

class Questiones:
    @require_safe
    def index(request):
        question = Question.objects.all()
        context = {
            'lists' : question,
        }
        return render(request, 'polls/index.html', context)

    @login_required
    @require_http_methods(['POST', 'GET'])
    def create(request):
        if request.method == 'POST':
            form = QuestionForm(request.POST)
            if form.is_valid():
                question = form.save(commit=False)
                question.user = request.user
                question = form.save()
                return redirect('polls:question_detail', question.pk)
        else:
            form = QuestionForm()

        context = {
            'form' : form,
        }
        return render(request, 'polls/form.html', context)

    @login_required
    @require_http_methods(['POST', 'GET'])
    def update(request, question_pk):
        question = get_object_or_404(Question, pk=question_pk)
        if request.user != question.user:
            return HttpResponseForbidden('페이지를 찾을 수 없습니다.')

        if request.method == 'POST':
            form = QuestionForm(request.POST, instance=question)
            if form.is_valid():
                question = form.save()
                return redirect('question_detail', question.pk)
        else:
            form = QuestionForm(instance=question)
        context = {
            'form' : form,
        }
        return render(request, 'polls/form.html', context)

    @require_safe
    def detail(request, question_pk):
        question = get_object_or_404(Question, pk=question_pk)
        reply = ReplyForm()
        context = {
            'list' : question,
            'form' : reply,
        }
        return render(request, 'polls/detail.html', context)

    @login_required
    @require_http_methods(['POST'])
    def delete(request, question_pk):
        question = get_object_or_404(Question, pk=question_pk)
        if request.user != question.user:
            return HttpResponseForbidden('페이지를 찾을 수 없습니다.')
        question.delete()
        return redirect('polls:question_index')


class Comment:
    @login_required
    @require_http_methods(['POST'])
    def create(request, question_pk):
        question = get_object_or_404(Question, pk=question_pk)
        form = ReplyForm(request.POST)
        if form.is_valid():
            reply = form.save(commit=False)
            reply.question = question
            reply.user = request.user
            reply.save()
        return redirect('polls:question_detail', question_pk)
    
    @require_http_methods(['POST'])
    @login_required
    def delete(request, reply_pk, question_pk):
        reply = get_object_or_404(Reply, pk=reply_pk)
        question = get_object_or_404(Question, pk=question_pk)
        # if reply.user != request.user:
        #     return HttpResponseForbidden('권한이 없습니다.')
        # reply.delete()
        # return redirect('polls:question_detail', question.pk)
        if request.user == reply.user:
            reply.delete()
        return redirect('polls:question_detail', question.pk)

    @login_required
    @require_http_methods(['POST'])
    def vote_reply(request, reply_pk, question_pk):
        # TODO: urls.py에서 url pattern/함수명 바꾸기 [나중에 해야할일]
        # FIXME: [당장고쳐야할일]
        reply = get_object_or_404(Reply, pk=reply_pk)
        question = get_object_or_404(Question, pk=question_pk)
        # 답변 작성자는 좋아요 투표못함
        if request.user == reply.user:
            return HttpResponseForbidden('자추금지')
        
        if reply.is_voted(request.user):
            reply.vote_users.remove(request.user)
        else:
            reply.vote_users.add(request.user)
        return redirect('polls:question_detail', question.pk)


    

