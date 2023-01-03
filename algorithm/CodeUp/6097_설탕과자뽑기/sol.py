import sys
sys.stdin = open('input.txt')

h, w = map(int, input().split())
matrix = [[0 for i in range(w)] for _ in range(h)]

n = int(input())


for i in range(n):
    # 8 1 3 3
    # 막대길이, 가로세로, 좌표x, 좌표y
    l, d, x, y = map(int, input().split())
    for col in range(l):
        if d == 0:
            matrix[x-1][col+y-1] ^= 1
        else:
            matrix[col-1+x][y-1] ^= 1

for i in range(h):
    print(*matrix[i])