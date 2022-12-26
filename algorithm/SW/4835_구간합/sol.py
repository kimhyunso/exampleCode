import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(1, T+1):
    N, M = map(int, input().split())
    numbers = list(map(int, input().split()))
    result = []

    for idx in range(N-M+1):
        result.append(sum(numbers[idx:idx+M]))

    print(f'#{tc} {max(result) - min(result)}')