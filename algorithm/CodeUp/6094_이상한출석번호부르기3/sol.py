import sys
sys.stdin = open('input.txt')


n = int(input())
numbers = list(map(int, input().split()))
prev = numbers[0]


for number in numbers:
    if prev > number:
        prev = number

print(prev) 
