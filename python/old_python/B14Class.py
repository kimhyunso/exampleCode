#B14Class.py

age = 13
print("type of age = ",type(age))

var = "Hellow Python"
print("type of var = ",type(var))


# Making class
# java : class Car{}
class Car :
    name = str()
    color = str()

    def printCar(self): #self가 없으면 안된다.
        print("color = ",self.color) #python : self = java : this
        print("name = ",self.name)


#java : Car texi = new Car();
taxi = Car()
bus = Car()

print("type of taxi = ",type(taxi))
taxi.name = "TAXI"
taxi.color = "RED"
taxi.printCar()

bus.name = "BMW"
bus.color = "Green"
bus.printCar()