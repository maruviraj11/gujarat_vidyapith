import math

def add(a,b):
    try:
        return a+b
    except Exception as e:
        return f"error in addition {e}"

def sub(a,b):
    try:
        return a-b
    except Exception as e:
        return f"error in subtraction {e}"
    

def mul(a,b):
    try:
        return a*b
    except Exception as e:
        return f"error in multiphication"

def div(a,b):
    try:
        if b==0:
            raise ValueError("NUMBER DOES NOT DIVIDIED 0...ERROR");
        return a/b
    except ValueError as ve:
        return f"value error {ve}"
    except Exception as e:
        return f"error in division {e}"
    

def factoriyal(n):
    try:
        if  not isinstance(n,int):
            raise TypeError("factoriyal does not interger value...!")

        if n<0:
            raise ValueError("factoriyal does not support in nagative value...!");
        if n==0 and n==1:
            return 1
        return n * factoriyal(n-1)
    except (TypeError,ValueError) as e:
        return (f"factoriyal error {e}")
    
def power(based,exponets):
    try:
        if not isinstance(exponets,int):
            raise TypeError("factoriyal does not integer value:")
        if exponets==0:
            return 0
        if exponets<0:
            return 1/(based-exponets)
        return based * power(based, exponets - 1)
    except(TypeError,ZeroDivisionError) as e:
        return f"power error ...{e}"
    
def log(value, base=math.e):
    try:
        if value <= 0 or base <= 0:
            raise ValueError("Logarithm undefined for non-positive values.")
        return math.log(value, base)
    except ValueError as ve:
        return f"ValueError: {ve}"
    except Exception as e:
        return f"Error in logarithm: {e}"
def sin(angle_rad):
    try:
        return math.sin(angle_rad)
    except Exception as e:
        return f"Error in sin function: {e}"

def cos(angle_rad):
    try:
        return math.cos(angle_rad)
    except Exception as e:
        return f"Error in cos function: {e}"
def tan(angle_rad):
    try:
        return math.tan(angle_rad)
    except Exception as e:
        return f"Error in tan function: {e}"
    
user_defined_functions = {}
    
def register_function(name, func):
    try:
        if not callable(func):
            raise TypeError("Provided function must be callable.")
        user_defined_functions[name] = func
    except TypeError as te:
        print(f"Error in registering function: {te}")

def execute_user_function(name, *args, **kwargs):
    try:
        if name not in user_defined_functions:
            raise ValueError(f"Function '{name}' is not registered.")
        return user_defined_functions[name](*args, **kwargs)
    except Exception as e:
        return f"Error executing user function '{name}': {e}"




    
