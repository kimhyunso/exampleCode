import sys
sys.stdin = open('input.txt')

def solve(numbers):
    max_value = numbers[0]
    min_value = numbers[0]
    for idx in range(1, len(numbers)):
        if max_value < numbers[idx]:
            max_value = numbers[idx]
        elif min_value > numbers[idx]:
            min_value = numbers[idx]
    return max_value - min_value


T = int(input())
answers = []

for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))

    print(f'#{tc} {solve(numbers)}')

