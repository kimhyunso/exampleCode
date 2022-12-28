import sys
sys.stdin = open('input.txt')

T = int(input())


for tc in range(1, T+1):
    N = int(input())
    metrix = [[0] * N for i in range(N)]

    """
    [0][0] [0][1] [0][2]
    [1][0] [1][1] [1][2]
    [2][0] [2][1] [2][2]
    """

    row = 0
    col = 0
    count = 1
    sep = 1

    # for idx in range(N, 0, -1):
    #     for col in range(idx):
    #
    #         metrix[row][col] = count
    #         if col < N-1:
    #             row += 1
    #             sep *= -1
    #         count += 1














