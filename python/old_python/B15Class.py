#B15 Class.py

class Car:
    nation = "Korea" #class variable

    def __init__(self,name,color,speed):
        self.name = name    #instance variable
        self.color = color
        self.speed = speed
    def printCar(self):
        print("(name, color, speed) = (",self.name,",",self.color,",",self.speed,")")

texi = Car("Texi","Red",100)
texi.printCar()

bus = Car("Bus","Yellow",77)
bus.printCar()