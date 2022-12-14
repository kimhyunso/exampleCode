#B04type.py


msg = "Hello Python World"

print("msg start = " , msg.startswith("Hello"))
print("msg end = ", msg.endswith("Python"))

print("msg replace = ",msg.replace("Python","MyPython"))
print("msg Capital = ",msg.capitalize())
print("msg upper = ",msg.upper())
print("msg lower = ",msg.lower())

print("msg find = ",msg.find("Python"))
print("msg find = ",msg.find("Java"))


#print("abcd"+123)
#"123" + 456
print("type casting = ", (int)("123") + 456 )

#complex number type
a = complex(1,2) # a = 1 + 2i
b = complex(3,4) # b = 3 + 4i
print("a = ",a)
print("b = ",b)

print("a*b = " , a*b)
