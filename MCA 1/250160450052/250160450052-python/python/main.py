# import grade
# import result

import grade
import result

while True:
    print("press 0: Exit the program\npress 1: Result Entry\npress 2: Grade")
    choice = input("Enter a choice..")

    if choice == "0":
        break
    elif choice == "1":
       per = result.result()
    elif choice == "2":
        #per = int(input("Enter percentage:"))
        grade.grade(per)
    else:
        print("invalid choice")
