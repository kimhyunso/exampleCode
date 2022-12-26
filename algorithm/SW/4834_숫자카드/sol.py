import sys

sys.stdin = open('input.txt')


def solved(numbers):
    new_dict = {}
    max_value = 0
    max_key = 0
    for number in numbers:
        new_dict[number] = numbers.count(number)

    for key in new_dict:
        if new_dict[key] >= max_value and max_key < key:
            max_value = new_dict[key]
            max_key = key
    return max_key, max_value

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    input_data = input()
    numbers = [int(data) for data in input_data]
    result, count = solved(numbers)
    print(f'#{tc} {result} {count}')
