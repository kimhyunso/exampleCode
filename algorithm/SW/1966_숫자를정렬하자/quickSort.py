import sys
sys.stdin = open('input.txt')

T = int(input())

def quick_sort(numbers):
    # 8
    if len(numbers) <= 1:
        return numbers
    # 4
    pivot = numbers[len(numbers) // 2]


    lesser_arr, equal_arr, greater_arr = [], [], []

    for num in numbers:
        if num < pivot:
            lesser_arr.append(num)
        elif num > pivot:
            greater_arr.append(num)
        else:
            equal_arr.append(num)
    return quick_sort(lesser_arr) + equal_arr + quick_sort(greater_arr)


for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))
    result = quick_sort(numbers)
    print(result)
