# main.py

import mymath   # import the module



x = int(input("Enter first number: "))
y = int(input("Enter second number: "))

result = mymath.add(x, y)   # call function from module
print("Addition =", result)
