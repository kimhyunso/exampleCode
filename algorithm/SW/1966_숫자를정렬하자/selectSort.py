import sys
sys.stdin = open('input.txt')


T = int(input())

for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))
    new_str = ''
    for col in range(len(numbers)):
        for row in range(col, len(numbers)):
            if numbers[col] > numbers[row]:
                # 5 + 1 = 6
                numbers[col] = numbers[col] + numbers[row]
                # 6 - 1 = 5
                numbers[row] = numbers[col] - numbers[row]
                # 6 - 5 = 1
                numbers[col] = numbers[col] - numbers[row]
        new_str += f'{numbers[col]} '

    print(f'#{tc} {new_str}')





