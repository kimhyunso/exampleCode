#B09 set.py
#set : 색인에 의한 순서 없는 데이터들의 모임
#A = {1,1,1,2,2,3,4,4} = {1,2,3,4}
#집합 : 중복된 데이터를 허용하지 않는다.

lang = {"C","PHP","Java","Python","JavaFX","JSP","C","Java"}
print(lang)
print("result = ","JSP" in lang)
print("result 2 = ","DART" in lang)

a = set("abcdefghijpythonworldphp")
b = set("myfavoritelangispython")

print("a = ",a)
print("b = ",b)

#차집합
print("a - b = ",a-b)

#교집합
print("a and b = ",a and b)

#합집합
print("a or b = ",a or b)

#여집합
print("a ^ b = ",a ^ b)

