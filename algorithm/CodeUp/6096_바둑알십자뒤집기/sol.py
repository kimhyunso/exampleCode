import sys
sys.stdin = open('input.txt')

matrix = [ list(map(int, input().split())) for _ in range(19)]

n = int(input())


for i in range(n):
    pos1, pos2 = map(int, input().split())
    for row in range(len(matrix)):
        matrix[row][pos2-1] ^= 1
        for col in range(len(matrix[0])):
            matrix[pos1-1][col] ^= 1


for m in matrix:
    print(*m)            




