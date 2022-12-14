#B17 Hidding.py - encapsulation
class Car:
    __nation = "Korea"
    def __init__(self,name,color):
        self.name = name
        self.color = color

    def printCar(self):
        print("name = ",self.name,", color = ",self.color,", nation = ",self.__nation)

    def getNation(self):
        return self.__nation

taxi = Car("Taxi","Red")
taxi.printCar()

print(taxi.getNation())



