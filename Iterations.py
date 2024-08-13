#Testing iteration loops
#Pre-Conditioned Iteration
    #Prints "Hello World" twice
for i in range(2):
    print("Hello World")


 #Single Embedded PreConditioned Iteration
    #Prints value 1 x3, 2x3 then 3 x3
x = 0
for i in range(3):
    x += 1
    for j in range(3):
        print(x)

    #Prints value 1 then 2 then 3 x3
x = 0
for i in range(3):
    x = 0
    for j in range(3):
        x += 1
        print(x)