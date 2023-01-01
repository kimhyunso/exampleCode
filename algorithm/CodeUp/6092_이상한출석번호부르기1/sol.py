import sys
sys.stdin = open('input.txt')



n = int(input())
numbers = list(map(int, input().split()))
count_lists = [0]*23

for i in range(len(numbers)):
    count_lists[numbers[i]-1] = numbers.count(numbers[i])

print(*count_lists)
