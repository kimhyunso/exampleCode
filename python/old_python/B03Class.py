#B03class.py

age = 13

age = age + 1

print("age = ",age)
print("type of age = " , type(age))
print("id of age = ",id(age))


age = "test message"
print("age = ",age)
print("type of age = " , type(age))
print("id of age = ",id(age))


print("-" * 30)
var1 = "I am Python"

var2 = "I am Python"
print("id of var1 = ",id(var1))
print("id of var2 = ",id(var2))
var2 = "new var2"

print("id of var1 = ",id(var1))
print("id of var2 = ",id(var2))


print("-"*30)
#data type : Number : int,double
#operator : +, -, *, /, %, ++, --, x**y(x 의 y제곱)
num = 10
testValue = var1 + age
print(testValue)

#java : "test" + 123 = "test123"

no = 1
#print("++no",++no)
#print("no++",no++)
#print("++no",++no)

print("no > 5 = ",no>5)


#testValue = var1 + num
#print("testValue = ",testValue)
#type 2 : logical data type : True , False
#if 문 속에서 동작을 결정할 때 사용

print("4 > 9 = ",4 > 9)
print("4 == 9 = ",4 == 9)
print("4 <= 9 =",4 <= 9)

#type 3 : string
print("Hello","Python","world")

print("Hello",
      "Python",
      "world")

msg = "Hello Python World"
print("Langth of ",msg , " = ",len(msg))
msg = "대한민국"
print("Langth of ",msg," = ",len(msg)







