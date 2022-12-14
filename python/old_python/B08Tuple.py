#B08tuple.py
#tuple : 변경할 수 없는(immutable) 리스트형
# 서로 다른 종류의 데이터형으로 이루어진 항목들을 모아놓은 쌍


movie = "Super man",1990,"Bat Man",2010,"Jurasic Park",2011
print(movie)

print("type of movie",type(movie))
print(movie[2])


table1 = [1,2,3] , [4,5,6]
print(table1)
#print("type of table1",type(table1))

(table1[0])[1] = 77
print("leng = ",len(table1))

emptyTuple = ()
print(emptyTuple)

test = "Hello"
print("type of test = ",type(test))
print("id of test = ",id(test))

test = "Hello" ,
print("type of test = ",type(test))
print("id of test = ",id(test))


print(movie)

a, b, c, d, e, f = movie
print("a = ",a)
print("b = ",b)
print("c = ",c)

list = list(movie)
print("list = ",list)

tuple = (231,4225,2342342)
print("id of tuple",id(tuple))
tuple =(1221,2222,3333)

print(tuple)
print("id of tuple",id(tuple))

#program languege
#변수 : int, float, string....
#list  : []
#tuple : ()
#set   : A = {1,2,3}


    
