cources={
        'JAVA101':('JAVA101','KAMPLESH'),
        'PYTHON103':('PYTHON103','AJAY'),
        'DS102':('DS102','NIPA')
}
enrolled={
        'JAVA101':['viraj','jay'],
        'PYTHON103':set(),
        'DS102':set()
}

def record_display():
    for cource_code,student in enrolled.items():
        cou_info=cources[cource_code]
        print("cource in ",cou_info)

        if student:
            print("student allready exits..")
        else:
            print(f"student in {student}")

def add_student(cource,student):
    if cource not in cources:
        print("cource allready exits...")
        return
    
    if student in enrolled[cources]:
        print("student already exits..")
    else:
        enrolled[cources].add(student)
        print("student successfully...")
    

while True:

    print("1.display details")
    print("2.add student")
    print("3.exit")

    ch=input("ENTER A ANY CHOICE..")
    ch=int(ch)

    if ch==1:
        record_display()
    elif ch==2:
        cource=input("enter a cource add..").upper()
        student=input("enter a student add..")
        add_student(cource,student)
    elif ch==3:
        print("exit")
        break

