import sys
sys.stdin = open('input.txt')

matrix = [[list(map(int, input().split()))] for _ in range(10)]

start, end = 2



for i in matrix:
    print(i)