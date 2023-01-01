import sys
sys.stdin = open('input.txt')

count = int(input())
matrix = [[0]*19 for i in range(19)]

for i in range(count):
    row, col = map(int, input().split())
    matrix[row-1][col-1] = 1


for m in matrix:
    print(*m)


