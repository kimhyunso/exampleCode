#B12For.py
#for x in range(10):
#for x in range(start,end,step):

for x in range(5,11,1):
    print(x,"^2 = ",x**2)

#table 변수에 값을 입력받아서 해당하는 구구단을 출력
    
#예 : 3을 입력하

#3*1 = 3
#3*2 = 6
#..
#3*9 = 27

#table = int(input("Insert table(0 = exit) : "))

#while table < 1 and table > 9 :
   #table = int(input("Insert table(0 = exit) : "))


#print("=======",table,"단=======")    
    
#for x in range(1,10,1):
    #print(table ," * ", x  ," = ", table * x )

# 이중 for문(nested for)
# 구구단을 출력하세요

print("-"*50)

for x in range(2,10,1):
    for y in range(1,10,1):
        print(x , " * ", y , " = ",x * y)


#사용자로부터 msg를 입력받는다(영어로 입력했다고 가정)
#입력받은 값을 역순으로 출력합니다.
#예 : hello world -> dlrow olleh
# Hint : len(msg) 는 msg의 길이를 나타낸다.

msg = input("Insert Message : ")
rmessage = ""

for x in range(len(msg),0,-1):
   rmessage = rmessage + (msg[x-1])

print(rmessage)