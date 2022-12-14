#B13fuction.py
#함수 만드는 방법
#def 함수 이름(인자1 , 인자2)
#이름을 물어본다. -> 나이를 물어보기 --> HI 누구, 너는 x살이군요.

def getNameAge():
    name = input("insert name : ")
    age =(int)(input("insert age : "))
    print("HI ",name," You Are ",age," years old !!")

def add(x,y):
    #print(x+y)
    return x+y

print("call fuction...")
#getNameAge()
#getNameAge()

#for x in range(1,10,1):
   #print(x," : ",add(3,x))

#def sum(x,y):
    #return x + y + 1

#k = sum(1,2)
#print("k = ",k)

def printCarInfo(maker,door=4,color="bule"):
    print("제조사 : ",maker," door : ",door,", color : ",color)
    print("id of maker ", id(maker))
    print("id of door ", id(door))
    print("id of color ", id(color))

#printCarInfo("현대차",4,"Red")
#printCarInfo("BMW")
#printCarInfo("KIA",5)
#printCarInfo(door=2,maker="Benz",color="Green")

#printf(%d,%d.....) : 가변인수
#표기법 : * tuple
#        ** dict 타입을 나타내는 표기법
def introFamily(name,*familyNames , **familyInfo):
    print("My name is ",name)
    print("My family name list is ",familyNames)
    for x in familyNames:
        print(x)
    print("-"*30)
    for key in familyInfo.keys():
        print(key, ":",familyInfo[key])
tuple = ("aaa","bbb",213124)
set = {tuple},{tuple},{tuple}
#introFamily("Hongjildong","Dad","Mom","Sister","Brother",주소="서울",가훈="잘먹고 잘살자")
introFamily("이름",("aaa","bbb",'c'),주소="서울",가훈="잘먹고 잘살자")

'''
name = "HongJilDong"
print("id 1 = ",id(name))

def memory(name):
    print("name = ",name)
    print("id of name = ",id(name))

name = "LeeSunSin"
memory(name)

memory("광개토")

memory("을지문덕")

'''

'''
def dummyFunction():
    """ 아무것도 수행하지 않고,
    내용만 기술하는 부분은 큰따옴표 세개로 둘러싼다.
    본 함수는 일반적으로 기능을 설명하거나
    개발자들이 알아야하는 내용을 표시할 때 사용
    """
    print("end of dummyFunction")

dummyFunction()

print(dummyFunction.__doc__)
'''

#함수를 하나 만들 예정입니다.
#다음처럼 함수를 호출

def playMultiplication(table):
    for x in range(1,10,1):
        print(table," * ",x," = ",table*x)

table = (int)(input("insert table : "))
playMultiplication(table)

