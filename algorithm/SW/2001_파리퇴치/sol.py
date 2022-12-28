import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(1, T+1):
    # 5, 2
    N, M = map(int, input().split())
    matrix = []
    result = []
    data = 0

    for idx in range(N):
        matrix.append(list(map(int, input().split())))

    """
    m[0][0]+m[0][1], m[0][1]+m[0][2], m[0][2]+m[0][3], m[0][3]+m[0][4]
    m[1][0]+m[1][1], m[1][1]+m[1][2], m[1][2]+m[1][3], m[1][3]+m[1][4]
    m[2][0]+m[2][1], m[2][1]+m[2][2], m[2][2]+m[2][3], m[2][3]+m[2][4]
    m[3][0]+m[3][1], m[3][1]+m[3][2], m[3][2]+m[3][3], m[3][3]+m[3][4]
    m[4][0]+m[4][1], m[4][1]+m[4][2], m[4][2]+m[4][3], m[4][3]+m[4][4]
    """
    left = 0
    right = 0

    while True:
        pass

    print(result)





