cources={
    'py101' :('py101','ajay parikh'),
    'ja201' :('ja201','kamlesh s'),
    'ds301': ('ds301','nipa s')
}
enrolled={
    'py101':['viraj','mohit'],
    'ja201':set(),
    'ds301':set()
}

def display():
    for cource,student in enrolled.items():
        cou_info=cources[cource]
        print("cource info",cou_info)

        if student:
            print(f"student is enrolled{student}")
        else:
            print("student is not ...")
    
def add_student(cource,student):
        
        if cource not in  cources:
            print("COURCE ARE NOT AVALIBLE")
        if student in enrolled[cource]:
            print("STUDENT IS ALLREADY ...ENROLLED!")
        else:
            enrolled[cource]=add.enrolled(student)
            
            

        while True:

            print("1.display \n")
            print("\n2.add student")
            print("\3.nexit")

            ch=input("Enter a any choice..")

            if ch==1:
                display()
                break
            if ch==2:
                cource=input("enter a any cource")
                student=input("enter a any student name")
                add_student(cource,student)
            if ch==3:
                break