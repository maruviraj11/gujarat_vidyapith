import time

def tprint(text, delay=0.05):
    for char in text:
        print(char, end='', flush=True)
        time.sleep(delay)

JAVA = ('MCA101', 'Dr.Kamlesh Saluke')
Python = ('MCA103', 'Dr.Ajay Parikh')
DS = ('MCA102', 'Neepa Shah')
DBMS = ('MCA104', 'Dr.Dhiren Patel')

studinfo=[]

enrollments = {
    JAVA: set(),
    Python: set(),
    DS: set(),
    DBMS: set()
}


while True:
    while True:
        tprint("\nWant to add new student [0 -> No , 1 -> Yes]: ", 0.02)
        choice = input()
        if choice.isdigit():
            choice=int(choice)
            break
        else:
            tprint('\nEnter only integer value', 0.03)
            
    if choice == 0:
        break
    elif choice == 1:
        while True:
            tprint("\nEnter Student's name:", 0.02)
            studName = input()
            if all(part.isalpha() for part in studName.split()):
                break
            else:
                tprint("\nEnter Valid Name!!", 0.03)

        while True:
            tprint("\nEnter the subject student enrolled in [1 -> JAVA , 2 -> Python , 3 -> DS , 4 -> DBMS]: ", 0.02)
            EnrolledSubject = input()
            if EnrolledSubject.isdigit():
                EnrolledSubject = int(EnrolledSubject)
                break
            else:
                tprint("\nEnter only integer value!!", 0.03)
            
        if EnrolledSubject == 1:
            course = JAVA
        elif EnrolledSubject == 2:
            course = Python
        elif EnrolledSubject == 3:
            course = DS
        elif EnrolledSubject == 4:
            course = DBMS
        else:
            tprint("\nInvalid subject choice.", 0.03)
            continue

        if studName in enrollments[course]:
            tprint(f"\nStudent '{studName}' already enrolled in {course}!", 0.03)
        else:
            enrollments[course].add(studName)
            studinfo.append(studName)
            tprint(f"\nAdded '{studName}' to {course}", 0.03)
    else:
        tprint("\nInvalid Input!!", 0.03)

tprint("\n--- Enrollments ---", 0.03)
for course, students in enrollments.items():
    tprint(f"\nAvailable Course: {course}", 0.03)

    if students == set():
        tprint(f"\nEnrolled Students: No student enrolled\n", 0.03)
    else:
        tprint(f"\nEnrolled Students: {students}\n", 0.03)

if studinfo == []:
    tprint(f"\nUpdated Students: No student added!", 0.03)
else:
    tprint(f"\nUpdated Students:{set(studinfo)}", 0.03)