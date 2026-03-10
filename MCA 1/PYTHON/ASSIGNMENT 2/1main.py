import scal as cal
import math

print("Addition is:",cal.add(10,20))
print("subtraction is :",cal.sub(20,10))
print("multiphication is:",cal.mul(10,10))
print("division is:",cal.div(20,10))
print("division by zero is:",cal.div(10,0))



print("factoriyal is of 5:",cal.factoriyal(5))
print("factoriyal is of -3 :",cal.factoriyal(-3))
print("factoriyal is of 3.5:",cal.factoriyal(3.5))

print("power (2^3)",cal.power(2,3))
print("Power (2^-2):", cal.power(2, -2))
print("Power (2^2.5):", cal.power(2, 2.5))

print("Natural Log (e):", round(cal.log(math.e), 5))
print("Log base 10 of 100:", cal.log(100, base=10))
print("Log of -10:", cal.log(-10))

print("sin(π/2):", cal.sin(math.pi / 2))
print("cos(0):", cal.cos(0))
print("tan(π/4):", round(cal.tan(math.pi / 4), 5))

def square(x):
    return x * x

cal.register_function('square', square)
print("Square of 7:", cal.execute_user_function('square', 7))
print("Non-registered function call:", cal.execute_user_function('unknown', 5))