import sys
sys.stdin = open('input.txt')

T = int(input())

for tc in range(1, T+1):
    metric = [[0]*10 for i in range(10)]
    N = int(input())
    result = 0

    for idx in range(N):
        pos1, pos2, pos3, pos4, color = list(map(int, input().split()))

        for row in range(pos1, pos3+1):
            for col in range(pos2, pos4+1):
                if metric[row][col] <= 1:
                    metric[row][col] = metric[row][col] + color
                else:
                    metric[row][col] = color
                if metric[row][col] >= 3:
                    result += 1

    print(f"#{tc} {result}")