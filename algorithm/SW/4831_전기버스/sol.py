import sys
sys.stdin = open('input.txt')

T = int(input())


for tc in range(1, T+1):
    K, N, M = map(int, input().split())
    charges = list(map(int, input().split()))
    bus_stations = [n for n in range(N+1)]
    while K >= N+1:


        K += K


    # print()