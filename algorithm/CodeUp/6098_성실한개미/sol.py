import sys
sys.stdin = open('input.txt')

matrix = [list(map(int, input().split())) for _ in range(10)]

start = end = 1

for row in range(start, len(matrix)):
    if matrix[row][end] == 2:
        matrix[row][end] = 9
        break
    for col in range(end, len(matrix)):
        if matrix[row][col] == 1:
            end -= 1
            break
        matrix[row][col] = 9


for i in matrix:
    print(i)


