import sys
sys.stdin = open('input.txt')


T = int(input())
result1 = 0
result2 = 0
max_value = 0

for tc in range(1, T+1):
    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))

    for idx in range(N-M+1):
        print(idx)

    # print(result1, result2)
