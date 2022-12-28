import sys
sys.stdin = open('input.txt')


T = int(input())

for tc in range(1, T+1):
    # V E
    V, E = map(int, input().split())
    metrix = [[] for i in range(V)]

    for idx in range(E):
        node1, node2 = map(int, input().split())
        metrix[node1].append(node2)

    print(metrix)

