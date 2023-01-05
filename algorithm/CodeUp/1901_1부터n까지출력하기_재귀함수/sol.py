import sys
sys.stdin = open('input.txt')

n = int(input())

def n_sum(number):
    if number == 1:
        print(number)
        return 1
    n_sum(number-1)
    print(number)

n_sum(n)










