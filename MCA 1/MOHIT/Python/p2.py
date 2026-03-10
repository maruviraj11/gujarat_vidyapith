print("=== Number Property Checker and Comparator ===")

a = int(input("Enter first integer value for A: "))
b = int(input("Enter second integer value for B: "))

print(f"\nA = {a}")
print(f"B = {b}")

print("\n--- Assignment Operations ---")
n1, n2 = a, b
print(f"n1 = a : {n1}")
print(f"n2 = b : {n2}")
n1 += a
n2 += b
print(f"n1 += a : {n1}")
print(f"n2 += b : {n2}")

print("\n--- Arithmetic Operations ---")
print(f"Addition       : {a} + {b} = {a + b}")
print(f"Subtraction    : {a} - {b} = {a - b}")
print(f"Multiplication : {a} * {b} = {a * b}")
# print(f"Division       : {a} / {b} = {a / b:.2f}")

print("\n--- Comparison Operations ---")
print(f"A == B : {a == b}")
print(f"A != B : {a != b}")
print(f"A > B  : {a > b}")
print(f"A < B  : {a < b}")

print("\n--- Logical Operations ---")
print(f"a and b : {a and b}")
print(f"a or b  : {a or b}")
print(f"not a   : {not a}")

print("\n--- Bitwise Operations ---")
print(f"a & b : {a & b}")
print(f"a | b : {a | b}")
print(f"a ^ b : {a ^ b}")

print("\n--- Membership Test ---")
L1 = [10, 20, 30]
print(f"L1 = {L1}")
print(f"A in L1       : {a in L1}")
print(f"B not in L1   : {b not in L1}")

print("\n--- Identity Test ---")
print(f"A is B       : {a is b}")
a = b
print(f"A is B (after assignment) : {a is b}")
print(f"A is not B   : {a is not b}")
