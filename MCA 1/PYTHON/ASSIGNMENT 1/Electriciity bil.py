rate=0
tbill=0
count = 1
while count!= 0:
    unit=int(input("Enter electricity units consumed"))
    #if unit>0:
      #  print("pleace enter positive number of unit..")
       # count = 0
    if unit>0 and unit<=100:
        print("Per unit rs.3 charge")
        rate=3
        count = 0
    elif unit>=101 and unit<=300:
        print("Per unit rs.5 charge")
        rate=5
        count = 0
    elif unit>=301 and unit<=500:
        print("Per unit rs.7 charge")
        rate=7
        count = 0
    elif unit >500:
        print("above 500unit per unit charge 10..")
        rate=10
        count = 0
    else:
        print("enter positive value in unit..!!") 
        count = 1

tbill=unit*rate


print("ELECTRIC BILL SUMMARY")
print("======================")
print(f"unit consumed::{unit}unit")
print(f"rate Applied:{rate}rate")
print(f"Total bill:{tbill}rs")


