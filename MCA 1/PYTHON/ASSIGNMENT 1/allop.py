
a=int(input("Enter a any number:"))
b=int(input("Enter a any number:"))

print("-------Assignment and arithmetic operations (=, +=, +, -, *, /) ----------")

x=a

print(f"x=a->x= {x}")
x+=b
print(f"x+=b->x={x}")
add=a+b
print(f"a+b={add}")
sub=a-b
print(f"a-b={sub}")
mul=a*b
print(f"a*b={mul}")
div=a/b
print(f"a/b={div}")

print("-----------------Comparison operation (==, !=, >, <) ---------------")
print(f"a==b->{a==b}")
print(f"a!=b->{a!=b}")
print(f"a>b->{a>b}")
print(f"a<b->{a<b}")

print("------------------Logical check operation(and,or,not)---------------------------")
print(f"a>0 and b>0->{a and b}")
print(f"a>0 or b>0->{a>0 or b>0}")
print(f"not(a>b){not(a>b)}")


print("------------------Bitwise operation----------------------------------")
print(f"a & b={a & b}")
print(f"a | b={a | b}")
print(f"a ^ b={a ^ b}")

print("-----------------Membership test--------------------------------------")
prelist = [10, 20, 30, 40, 50]
print(f"a in {prelist} → {a in prelist}")
print(f"b not in {prelist} → {b not in prelist}")

print("\n--- Identity Test ---")
print(f"a is b → {a is b}")
a=b
print(f"a is b after assignment → {a is b}")
print(f"a is not b → {a is not b}")