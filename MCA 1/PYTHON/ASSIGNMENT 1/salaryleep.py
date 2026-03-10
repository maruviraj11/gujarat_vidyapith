name=input("Enter a Employee name:")
id=input("Enter a Employee id:")
bsalary=float(input("Enter a Basic salary:"))

hra=bsalary*0.20
ta=bsalary*0.05
da=bsalary*0.15
pf=bsalary*0.12

gross_salary=bsalary+hra+ta+da
net_salary=gross_salary-pf

print("\n-------------------salary slip-----------------------")
print(f"Employee ID :     {id}")
print(f"Employee Name:     {name}")
print("--------------------------------------------------------")
print(f"Basic Salary:     rs{bsalary:.2f}")
print(f"HRA(20%):         rs{hra}")
print(f"DA(10%):          rs{da}")
print(f"TA(5%):           rs{ta}")
print(f"PF(12%):          rs{pf}")
print("---------------------------------------------------------")
print(f"Gross salary:     rs{gross_salary:.2f}")
print(f"net salary:       rs{net_salary:.2f}")
print("---------------------------------------------------------")

