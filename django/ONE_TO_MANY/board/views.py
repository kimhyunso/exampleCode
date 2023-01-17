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
        from django.db.models import Count
        # Article 테이블에 가상의 컬럼(annotate)를 만들며,
        # 컬럼 이름은 like_count고, like_users를 Count해서 채울 것이며, 이 가상의 컬럼을 기준으로 내림차순정렬하겠다.
        list = Board.objects.annotate(like_count=Count('like_users')).order_by('-like_count')
        context = {
            'lists' : list,
        }
        return render(request, 'board/index.html', context)

    @require_safe
    def detail(request, board_pk):
        # board 상세페이지 Form
        board = get_object_or_404(Board, pk=board_pk)
        # comment Form
        form = CommentForm()
        # 좋아요 버튼 Flag
        is_like = board.like_users.filter(pk=request.user.pk).exists() 
        # html에보낼 데이터 꾸러미
        context = {
            'list' : board,
            'form' : form,
            # 'comments' : board.comment_set.all(),
            'is_like' : is_like,
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

    @require_POST
    @login_required
    def like_board(request, board_pk):
        board = get_object_or_404(Board, pk=board_pk)
        request.user.like_boards.remove(board) if board.like_users.filter(pk=request.user.pk).exists()  else request.user.like_boards.add(board)
        return redirect('board:board_detail', board_pk)



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
