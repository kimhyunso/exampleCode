#B26File.py


file = open("d:/test.txt","w")
#"file open mode"
#"w : write, 쓰기모드, 기존 파일이 있으면 덮어씀"
#"r : read, 읽기 전용 (기본)"
#"x : execlusive, 파일이 이미 있으면 실패하고, 없으면 쓰기모드"
#"a : append, 내용 추가"
#"b : binary"
#"t : text"
#"+ : reading and writing. 읽고 쓰기 가능 하지만 위험"

file.write("ABCDHello Python File World\n")
age = 13
name = "Hong jil dong"
msg = "HI~~ My Name is"+name+"My years old is "+str(age)
file.write(msg)
file.flush()

file.close()

print("is Closed ? ",file.closed)

file = open("d:/test.txt","rt")

#한줄을 읽어옴
print("file 내용은 = ",file.readline())
#리스트 형으로 줄단위를 읽어옴
print("file 내용은 = ",file.readlines())
print("-"*50)

#커서를 처음을 기준으로 얼만큼 갈 것인지...
file.seek(10,0)

for line in file:
    print(line)

print("file position = ",file.tell())


file.close()


