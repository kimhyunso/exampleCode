def man(switch_lists, get_switch):
    change_switch = get_switch
    for idx in range(1, len(switch_lists)):
        if change_switch == idx:
            if switch_lists[idx-1] == 1:
                switch_lists[idx-1] = 0
            else:
                switch_lists[idx-1] = 1
            change_switch += change_switch

def woman(swich_lists, get_switch):
    chagne_switch = get_switch - 1
    count = 1

    for pivot in range(len(swich_lists)):
        if chagne_switch == pivot:
            head = pivot - 1
            if swich_lists[pivot] == 0:
                swich_lists[pivot] = 1
            else:
                swich_lists[pivot] = 0

            for i in range(head, -1, -1):
                if i+2*count > len(swich_lists) -1 or swich_lists[i] != swich_lists[i+2*count]:
                    break
                else:
                    if swich_lists[i] == 1 and swich_lists[i+2*count] == 1:
                        swich_lists[i] = 0
                        swich_lists[i+2*count] = 0
                    else:
                        swich_lists[i] = 1
                        swich_lists[i+2*count] = 1

                count += 1

T = int(input())
switch_lists = list(map(int, input().split()))
students = int(input())
new_str = ''

for student in range(students):
    gender, get_switch = map(int, input().split())

    if gender == 1:
        man(switch_lists, get_switch)
    else:
        woman(switch_lists, get_switch)


for idx in range(len(switch_lists)):
    new_str += f'{switch_lists[idx]} '
    if idx >= 20:
        new_str += '\n'

print(new_str)