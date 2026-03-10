while True:
    empName=input("Enter Employee's name:")
    if all(part.isalpha() for part in empName.split()):
        break
    else:
        print('Please enter valid name.')

empId=int(input("Enter Employee's ID:"))
basicSalary=float(input("Enter basic salary:"))
bonusPer=float(input("Enter bonus percentage:"))

totalSalary=basicSalary + basicSalary * bonusPer / 100
print("'" * 40)
print("\t      SALARY SLIP")
print('='*40)
print(f'  Employee ID       : {empId}           ')
print(f'  Employee Name     : {empName}         ')
print(f'  Basic Salary      : ₹{basicSalary:,.2f}')
print(f'  Bonus percentage  : {bonusPer:,.2f} %   ')
print('-'*40)
print(f'  Total Salary      : ₹{totalSalary:,.2f}')
print("'" * 40)