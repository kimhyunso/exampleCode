#B35_3Dgraph.py
import numpy as np
import matplotlib.pyplot as graph

#for 3D graph
from matplotlib import cm
from mpl_toolkits.mplot3d import Axes3D

fig = graph.figure(figsize=(8,8))
fig.suptitle("$f(x,y) = x^2 + y^2$", color="#0000FF", fontsize=20)

x = np.linspace(-5, 5, 30)
y = np.linspace(-5, 5, 30)
X, Y = np.meshgrid(x, y)
Z = X**2 + Y**2

ax3 = fig.add_subplot(111, projection='3d')
surf = ax3.contour(X, Y, Z)
ax3.set_title("contour Frame")
graph.show()