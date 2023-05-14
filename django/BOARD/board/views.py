from django.shortcuts import render, redirect, get_object_or_404
from django.views.decorators.http import require_http_methods, require_safe
from .forms import BoardForm
from .models import Board
# Create your views here.

@require_safe
def board_index(request):
    contenxt = {
        'lists' : Board.objects.all(),
    }
    return render(request, 'board/index.html', contenxt)

@require_safe
def board_detail(request, board_pk):
    context = {
        'list' : get_object_or_404(Board, pk=board_pk),
    }
    return render(request, 'board/detail.html', context)


@require_http_methods(['POST', 'GET'])
def board_update(request, board_pk):
    board = get_object_or_404(Board, pk=board_pk)
    if request.method == "POST":
        form = BoardForm(request.POST, instance=board)
        if form.is_valid():
            board = form.save()
            return redirect('board:board_detail', board.pk)
    else:
        form = BoardForm(instance=board)

    context = {
        'form' : form,
    }
    return render(request, 'board/update.html', context)
 
@require_http_methods(['POST'])
def board_delete(request, board_pk):
    board = get_object_or_404(Board, pk=board_pk)
    board.delete()
    return redirect('board:board_index')


@require_http_methods(['POST', 'GET'])
def board_create(request):
    if request.method == 'POST': 
        form = BoardForm(request.POST)
        if form.is_valid():
            board = form.save()
            return redirect('board:board_detail', board.pk)
    else:
        form = BoardForm(request.POST)
    context = {
        'form' : form,
    }
    return render(request, 'board/create.html', context)