import time

while True:
    rows = input("Enter number of rows: ")
    if rows.isdigit():
        rows = int(rows)
        break
    else:
        print("Enter only Integer Number!!")


for i in range(rows):
    value = 1
    l1 = []
    for j in range(i + 1):
        time.sleep(0.2)
        l1.append(value)
        value = value * (i - j) // (j + 1)
        
    print(l1)
