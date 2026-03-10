import time

while True:
    now = time.strftime("%H:%M:%S")   # Hours:Minutes:Seconds
    print(now, end="\r")              # overwrite the same line
    time.sleep(1)                     # wait 1 second
