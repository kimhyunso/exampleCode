import sys
sys.stdin = open('input.txt')
# 2, 7
x, y = map(int, input().split())

def solved(x, y):
    if x % 2 != 0:
        print(x)
    if x == y:
        return
    solved(x+1, y)

solved(x, y)