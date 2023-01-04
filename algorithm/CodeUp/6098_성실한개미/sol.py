import sys
sys.stdin = open('input.txt')

matrix = [list(map(int, input().split())) for _ in range(10)]

row = col = 2 - 1

while matrix[row][col] != 2:
    while matrix[row][col] != 1:
        matrix[row][col] = 9
        col += 1
    row += 1



