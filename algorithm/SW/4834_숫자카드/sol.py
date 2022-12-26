import sys

sys.stdin = open('input.txt')


def solved(numbers):
    new_dict = {}
    max_value = '0'
    count = 2
    for number in numbers:
        if numbers.count(number) >= count:
            new_dict[int(number)] = count
            count = numbers.count(number)
        elif numbers.count(number) == 1 and max_value < number:
            max_value = number
            new_dict[int(number)] = 1
    return new_dict

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    numbers = input()

    data_dicts = solved(numbers)
    check_value = 0
    result = 0
    count = 0
    for key in data_dicts:
        if data_dicts[key] > check_value:
            check_value = data_dicts[key]
            count = data_dicts[key]
            result = key

    print(f'#{tc} {result} {count}')
