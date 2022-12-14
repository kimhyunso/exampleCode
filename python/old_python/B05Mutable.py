# B05Mutable.py
#파이썬은 수학 계산을 편리 하게 사용하게끔 만들어진 언어


var1 = "Hello World"
var2 = "Hello World"


print("id of var1",id(var1))
print("id of var2",id(var2))


var2 = "Java World"
print("id of var1",id(var1))
print("id of var2",id(var2))

#memory 사용을 최소화해서 , 필요한 경우에만 객체를 만든다.
#var1 , var2 처럼 var2의 메모리값을 바꿨을 때
#동일한 메모리를 사용할 수 없고, 새로 객체를 만드는 현상 : immutable

msg = "Hello"
print("id of msg = ",id(msg))
msg = "Python"
print("id of msg = ",id(msg))

#python의 데이터 구분
#Immutable Data Type         Mutable Data type
#숫자형(int , float , complex)  list
#문자(string)                   dict
#tuple                          set
#byte                           byte array

age = 13
print("id of age = ",id(age))
age =14
print("id of age = ",id(age))

