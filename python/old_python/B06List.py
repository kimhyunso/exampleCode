#B06List.py

list = [10, 20, 30, 40, 50]
print("list = ",list)
print("list[0] = ",list[0])
print("list[3] = ",list[3])
print("list[-2] = ",list[-2])
print("len of list = ",len(list))

list.append(77)
list.append(88)
print("list = ",list)


nameList = ["AAA","BBB","CCC","DDD"]
print("nameList = ",nameList)

testList = ["AAA","BBB",333,"DDD",4.0]
print("testList = ",testList)

#remove
list.remove(40) #not index, value
print("list after remove = ",list)

#insert
list.insert(1,99)
print("list after insert = ",list)

#pop
list.pop(2)
print("list after pop = ",list) #index

#자르기
subList = list[0:4]
print("subList = ",subList)

#copy
clone = list
print("clone = ",clone)

newClone = list[:]
print("newClone = ",newClone)

a = [1,2,3]
b = [4,5,6,7]
c = a + b
print("list c = ",c)

del c[1:3]
print("del c =  ", c)

del c[:]
print("del c = ",c)

print("type of c = ",type(c))



