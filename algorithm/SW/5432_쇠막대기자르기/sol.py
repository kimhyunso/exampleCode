import sys
sys.stdin = open('input.txt')

def razer(N):
    razer_lists = [i for i in N]
    for data in razer_lists:
        current = razer_lists.pop()
        prev = razer_lists.pop()



T = int(input())
for tc in range(1, T+1):
    N = input()
    razer(N)

    print(f'#{tc}')



