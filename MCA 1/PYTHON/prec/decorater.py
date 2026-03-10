def decorater(func):
    def wraper():
        print("before addition..")
        func()
        print("after addition..")
    return wraper

@decorater
def add():
    a=10
    b=20
    print("sum of the number..",a+b)

add()