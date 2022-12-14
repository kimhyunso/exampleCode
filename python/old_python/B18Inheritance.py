#B18Inheritance.py

class Car:
    def __init__(self,name,color):
        self.name = name
        self.color = color
    def printCar(self):
        print("name = ",self.name,", color = ",self.color)

#java
#class SportCar extends Car {}

class SportsCar(Car):
    def __init__(self,name,color,turbo=True):
        super(SportsCar,self).__init__(name,color)
        self.turbo = turbo

    def printCar(self):
        print("name = ",self.name,", color = ",self.color,", turbo = ",self.turbo)

taxi = Car("Taxi","Red")
taxi.printCar()

superCar = SportsCar("BWN","Yellow")
superCar.printCar()