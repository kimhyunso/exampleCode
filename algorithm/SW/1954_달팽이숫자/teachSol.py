import sys
sys.stdin = open('input.txt')


def solution(N):
    matrix = [[0 for _ in range(N)] for _ in range(N)]
    number = 1
    row = col = 0
    move = +1

    for i in range(N, 0, -1):
        if i == 1:  # 완전 마지막 칸 채우기
            matrix[row][col] = number
        else:
            # 가로 이동(좌/우)
            for k in range(i):  # 0 ~ (i-1)
                # 채우고
                matrix[row][col] = number
                # 숫자 올리고
                number += 1
                if k == i - 1:   # 마지막 회차에는
                    row += move  # 상/하 이동시킴

                else:           # 나머지는 좌/우 이동
                    col += move
            # 세로 이동(상/하)
            for k in range(i-1):  # 0 ~ (i-2)
                # 채우고
                matrix[row][col] = number
                # 숫자 올리고
                number += 1

                if k == i - 2:   # 마지막 회차에는
                    move *= -1   # 방향 전환(양수 <=> 음수)
                    col += move  # 좌/우 이동

                else:           # 나머지는 상/하 이동
                    row += move

    return '\n'.join([' '.join(map(str, row)) for row in matrix])


T = int(input())
for tc in range(1, T+1):
    print(f'#{tc}\n{solution(int(input()))}')