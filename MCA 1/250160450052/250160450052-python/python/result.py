#this is result modual
per=0
def result():

    marks1=int(input("Enter a first subject marks.."))
    marks2=int(input("Enter a secound subject marks.."))
    marks3=int(input("Enter a thired subject marks.."))

    total=marks1+marks2+marks3

    per=total/3

    print("---------------Student result card -----------------")
    print(f"student first subject narks is={marks1}")
    print(f"student secound subject narks is={marks2}")
    print(f"student third subject narks is={marks3}")
    print(f"Total Marks is={total}")
    print(f"Percentage is ={per}")

    return per



