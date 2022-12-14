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
Z = X**2 + Y**2 * np.tan(x)

ax1 = fig.add_subplot(221, projection='3d')
surf = ax1.plot_wireframe(X,Y,Z)
ax1.set_title("wire Frame")

ax2 = fig.add_subplot(222, projection='3d')
surf = ax2.plot_surface(X,Y,Z, rstride=1, cstride=1, cmap=cm.RdPu)
ax2.set_title("wire surface")

ax3 = fig.add_subplot(223, projection='3d')
surf = ax3.contour(X, Y, Z)
ax3.set_title("wire surface")

ax4 = fig.add_subplot(224, projection='3d')
surf = ax4.scatter(X, Y, Z)
ax4.set_title("scatter Frame")

graph.show()