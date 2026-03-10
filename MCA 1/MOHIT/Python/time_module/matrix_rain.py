import time, random, string

for i in range(20):
    line = ''.join(random.choice(string.ascii_letters + string.digits) for _ in range(60))
    for char in line:
        print(char,end="  ")
        time.sleep(0.01)   # small delay between lines
