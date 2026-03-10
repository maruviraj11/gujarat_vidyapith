import time

def tprint(text, delay=0.05):
    for char in text:
        print(char, end='', flush=True)
        time.sleep(delay)
    print()

count = 1
while count != 0:
    tprint("Enter Unit consumed.:", 0.03)
    unit = input() 
    
    if unit.lstrip('-').isdigit() and unit != '-':
        unit = int(unit)

        if unit > 0 and unit <= 100:
            rate = 3
            count = 0
        elif unit >= 101 and unit <= 300:
            rate = 5
            count = 0
        elif unit >= 301 and unit <= 500:
            rate = 7
            count = 0
        elif unit > 500:
            rate = 10
            count = 0
        else:
            tprint("Enter valid Value in unit!!", 0.03)
            count = 1
    else:
        tprint("Enter only Integer value!!", 0.03)
        count = 1

bill = unit * rate

tprint("\nElectricity Bill Summary", 0.03)
tprint("-"*24, 0.01)
tprint(f"Unit consumed : {unit}", 0.03)
tprint(f"Rate Applied : ₹{rate} per unit", 0.03)
tprint("="*24, 0.01)
tprint(f"Total Bill : ₹{bill:,.2f}", 0.03)
