import time
import random

print("Get ready...")
time.sleep(random.randint(1,3))  # random wait before starting
print("Go!")

start = time.time()
input("Press Enter as fast as you can! ")
end = time.time()

reaction_time = end - start
print(f"Your reaction time: {reaction_time:.3f} seconds")