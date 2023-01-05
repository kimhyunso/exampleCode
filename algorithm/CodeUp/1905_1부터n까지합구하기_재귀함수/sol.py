import sys
sys.stdin = open('input.txt')

n = int(input())

def solved(n):
    if n == 1:
        return 1
    solved(n) + solved(n-1)

print(solved(n))