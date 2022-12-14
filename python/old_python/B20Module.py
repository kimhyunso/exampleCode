#B20Module.py

def multi():
    for x in range(2,10,1):
        print("=== Table",x,"===")
        for y in range(1,10,1):
            print(x," * ",y," = ",x*y)

def showTable(table):
    print("=== Table",table,"====")
    for x in range(1,10,1):
        print(table," * ",x," = ",table*x)
