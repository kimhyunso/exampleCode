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
    block = N - 1
    # 1. block ?
    # 2. pivot

    while row != 1 and col != 1:
        metrix[row][col] = count
        # 블럭을 만나지 않으면 진행하라
        if col != block and row != block:
            col += 1
        # 밑으로 가다가 막힘
        elif row == block:
            col -= 1
        # 오른쪽으로 가다가 막힘
        elif col == block:
            row += 1
        # 밑으로도 못 내려가고, 왼쪽으로도 못 갈 경우
        elif row == block and col == 0:
            row -= 1
        count += 1

for data in metrix:
    print(data)












