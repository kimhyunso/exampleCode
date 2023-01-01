import sys
sys.stdin = open('input.txt')

count = int(input())
numbers = list(map(int, input().split()))
count_lists = []

for i in range(count-1, -1, -1):
    count_lists.append(numbers[i])

print(*count_lists)


