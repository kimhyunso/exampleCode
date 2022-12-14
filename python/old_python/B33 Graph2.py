#B33Graph2.py

import matplotlib.pyplot as graph
import numpy as np
#no = 30

#x = np.arange(no)
#x = np.arange(5)
#y = np.array([1,3,5,7,9])
#y = np.arange(no)


#graph.plot(x,x*x , "b-",x,x*x,"rD")

#maker
# o : circle, 8 : octagon, p : pentagon, +, D : diamond
#| , s : square, * : start, x, d : small diamond
#color maker
# b, k : black, r : red , m :magenta, c : cyan


x = np.linspace(0,2*np.pi,num = 100)
y1 = np.sin(x)
y2 = np.cos(x)

graph.plot(x,y1,"k-",label="y=sin(x)")
graph.plot(x,y2,"b-",label="y=cos(x)")

xmin, xmax, ymin, ymax = x[0], x[-1], -2, 2
graph.axis([xmin,xmax,ymin,ymax])

graph.legend(loc="best")


graph.xlabel("x")
graph.ylabel("y")

graph.title("Plot Maker")
graph.grid(True)
graph.show()