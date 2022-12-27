import sys
sys.stdin = open('input.txt')

T = int(input())


for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))
    new_str = ''
    for col in range(len(numbers)):
        for row in range(len(numbers)-1):
            if numbers[row] > numbers[row+1]:
                numbers[row] = numbers[row] + numbers[row+1]
                numbers[row+1] = numbers[row] - numbers[row+1]
                numbers[row] = numbers[row] - numbers[row+1]

    for num in numbers:
        new_str += f'{num} '

    print(f'#{tc} {new_str}')


