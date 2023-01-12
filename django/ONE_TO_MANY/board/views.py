from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_http_methods, require_safe, require_POST
from .models import Board, Comment
from .forms import BoardForm, CommentForm


class BoardViews:
    @require_http_methods(['GET', 'POST'])
    def create(request):
        # 글쓰고 제출
        if request.method == 'POST':
            board_form = BoardForm(request.POST)
            if board_form.is_valid():
                board = board_form.save()
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



class CommentViews:
    @require_http_methods(['POST'])
    def create(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        comment_form = CommentForm(request.POST)
        if comment_form.is_valid():
            comment = comment_form.save(commit=False)
            comment.board = board
            comment.save()
        return redirect('board:board_detail', board_pk)

        
    @require_http_methods(['POST'])
    def delete(request, comment_pk, board_pk):
        comment = get_object_or_404(Comment, pk=comment_pk)
        board = get_object_or_404(Board, pk=board_pk)
        comment.delete()
        return redirect('board:board_detail', board.pk)

    def update(request):
        pass



