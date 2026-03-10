# This is grade modual
import result
def grade(per):

    print("---------student Grade ---------")
    if(per>=90):
        print("Grade=A+") 
    elif(per>=75 and per<90):
        print("Grade=A")
    elif(per>=60 and per<75):
        print("Grade=B")
    elif(per>=40 and per<60):
        print("Grade=C")
    else:
        print("FAIL")

