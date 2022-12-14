#B24 Login.py

import B23Pass as p

#myPass = input("insert PassWord : ")
#p.validatePassword(myPass)

#printf()
msg = "Hello World"
print("msg = ",msg)
print("HI~~~{}".format(msg))
name = "Hong jil dong"
age = 23
#DataBase 사용시 편리
print("HI ~~{} You are {} years old".format(name,age))
#c : printf("%05d",age); //00012

print("You Are {:<20} Years Old".format(age))

print("You Are {:>20} Years Old".format(age))

print("You Are {:^20} Years Old".format(age))

print("You Are {:*^20} Years Old".format(age))

print("You Are {:.>20} Years Old".format(age))

import math
pi = math.pi
print("pi = ",pi)
print("pi = {:.2f}".format(pi))
print("pi = {:.3f}".format(pi))
print("pi = {:f}".format(pi))
print("pi = {:+f}".format(pi))
print("pi = {:+.3f}".format(pi))

#큰 숫자를 표기할 떄 읽기 어렵다.
#123,456,123,321,312
#123,456,123,321,312
#1,123,456,123,321,312
#1123,4561,2332,1312
# 조 억 만
#python : php의 number_format()
num = 12345678912345

print("num = {}".format(num))
print("num = {:,}".format(num))
print("1/3 = {}".format(1/3))
print("1/3 = {:.3f}".format(1/3))
print("1/3 = {:%}".format(1/3))
print("1/3 = {:.2%}".format(1/3))





