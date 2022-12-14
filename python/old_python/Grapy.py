#grapy.py

import turtle

turtle.showturtle();
turtle.speed(0)

turtle.right(90)
turtle.forward(300)

turtle.right(-90)
turtle.forward(400)

turtle.right(-90)
turtle.forward(600)

turtle.right(-90)
turtle.forward(800)

turtle.right(-90)
turtle.forward(600)

turtle.right(-90)
turtle.forward(400)
turtle.forward(400)
turtle.right(-90)

for x in range(10,1000,10):
    turtle.right(-x)
    turtle.right(90 + x)
    turtle.forward(600)






