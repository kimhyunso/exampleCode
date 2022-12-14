#B11 controll.py
#제어문 : switch 문이 없다.
#if, for, while, break, continue, pass
#java : if(){}else{}


degree = 75
# >= 90 : A
# >= 80 : B
# >= 70 : C
# F

if degree >= 90:
    print("A")
elif degree >= 80:
    print("B")
elif degree >= 70:
    print("C")
else :
    print("F")


#사용자로 부터 색상을 받는다.
#만약 파란색 : blue
# 건널 준비가 되어있습니까?(yes/no)
# yes : PASS
# no : WAIT
#만약 빨간색 : red
# STOP
#다른 색을 입력했으면, 잘못된 색상입니다.

color = input("insert color : ")


if color.lower() == "blue":
    yesORno = input("Are You Read ? ")
    if yesORno.lower() == "yes":
        print("PASS")
    elif yesORno.lower() == "no":
        print("WAIT")
    else :
        print("Unknown Answer")
        
elif color.lower() == "red":
    print("STOP")
else:
    print("Unknown Color")

    
    
    
 
    

