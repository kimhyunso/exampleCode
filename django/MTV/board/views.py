from django.shortcuts import render, redirect
from .models import Board
from .models import Replay


class Post_Replay:
    pass



# Create your views here.

class Post_Board:
    def view(request):
        # 기본 => id 오름차순
        # 내림차순으로 바꾸기
        # 1. Board.ojects.all()[::-1]
        # 2. Board.ojects.order_by('-pk')
        context = {
            'lists' : Board.objects.order_by('-pk'),
        }
        return render(request, 'board/index.html', context)


    def create(request):
        return render(request, 'board/create.html')

    def make(request):
        board = Board()
        board.title = request.POST['title']
        board.content = request.POST['content']
        board.writer = request.POST['writer']
        board.save()
        return redirect('board:detail', board.id)

    def edit(request, board_pk):
        context = {
            'list' : Board.objects.get(pk=board_pk),
        }
        return render(request, 'board/edit.html', context)

    def update(request, board_pk):
        board = Board.objects.get(pk=board_pk)
        board.title = request.POST['title']
        board.content = request.POST['content']
        board.writer = request.POST['writer']
        board.save()
        return redirect('board:detail', board.id)


    def detail(request, board_pk):
        context = {
            'list' : Board.objects.get(pk=board_pk),
        }
        return render(request, 'board/detail.html', context)


    def delete(request, board_pk):
        board = Board.objects.get(pk=board_pk)
        board.delete()
        return redirect('board:index')