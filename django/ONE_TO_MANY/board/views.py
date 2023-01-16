from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_http_methods, require_safe, require_POST
from django.contrib.auth.decorators import login_required
from .models import Board, Comment
from .forms import BoardForm, CommentForm


class BoardViews:
    @login_required
    @require_http_methods(['GET', 'POST'])
    def create(request):
        # 글쓰고 제출
        if request.method == 'POST':
            board_form = BoardForm(request.POST)
            if board_form.is_valid():
                board = board_form.save(commit=False)
                board.user = request.user
                board.save()
                return redirect('board:board_detail', board.pk)
        # html을 보여줌
        else:
            board_form = BoardForm()
        context = {
            'form' : board_form,   
        }
        return render(request, 'board/form.html', context)

    @require_safe
    def index(request):
        context = {
            'lists' : Board.objects.order_by('-pk'),
        }
        return render(request, 'board/index.html', context)

    @require_safe
    def detail(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        form = CommentForm()
        context = {
            'list' : board,
            'form' : form,
            'comments' : board.comment_set.all()
        }
        return render(request, 'board/detail.html', context)

    @login_required
    @require_http_methods(['POST', 'GET'])
    def update(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        if request.method == 'POST':
            # 글수정
            board_form = BoardForm(request.POST, instance=board)
            if board_form.is_valid():
                if request.user != board.user:
                    return redirect('board:board_index')
                board_form.save(commit=False)
                board_form.user = request.user
                board_form.save()
                next = request.GET.get('next')
                return redirect(next or 'board:board_detail', board.pk)
        else:
            # html 반환
            board_form = BoardForm(instance=board)
        context = {
            'form' : board_form,
        }
        return render(request, 'board/form.html', context)

    @login_required
    @require_http_methods(['POST'])
    def delete(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        if request.user == board.user:
            board.delete()
        return redirect('board:board_index')

class CommentViews:
    @login_required
    @require_http_methods(['POST'])
    def create(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        comment_form = CommentForm(request.POST)
        if comment_form.is_valid():
            comment = comment_form.save(commit=False)
            comment.board = board
            comment.user = request.user
            comment.save()
        return redirect('board:board_detail', board.pk)

    @login_required   
    @require_http_methods(['POST'])
    def delete(request, comment_pk, board_pk):
        comment = get_object_or_404(Comment, pk=comment_pk)
        board = get_object_or_404(Board, pk=board_pk)
        if request.user == comment.user:
            comment.delete()
        return redirect('board:board_detail', board.pk)
 
    def delete(request):
        pass


