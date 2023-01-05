import sys
sys.stdin = open('input.txt')

n = int(input())

def solved(n):
    print(n)
    if n == 1:
        return n
    return solved(n-1)


solved(n)

