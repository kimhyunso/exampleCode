import sys
sys.stdin = open('input.txt')

T = int(input())


for tc in range(1, T+1):
    K, N, M = map(int, input().split())
    charges = list(map(int, input().split()))
    bus_stations = [n for n in range(N+1)]
    result = 0
    for charge in charges:
        bus_stations[charge] = 'o'

    print(bus_stations)

    for idx in range(0, len(bus_stations), K):
       pass

    print(f'#{tc} {result}')






    # print()