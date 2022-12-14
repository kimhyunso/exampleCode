#B16 Var.py
#class 변수와 instance 뱐수를 구분하는 예

class Dog:
    tricks = []  #class variable : 인스턴스간 공유

    def __init__(self,name):
        self.name = name

    def addTricks(self,tricks):
        self.tricks.append(tricks)

# foo, bar
foo = Dog("foo")
bar = Dog("bar")

foo.addTricks("rolling")
bar.addTricks("barking")
foo.addTricks("sleeping")
bar.addTricks("eatting")

print(foo.tricks)
print(bar.tricks)
