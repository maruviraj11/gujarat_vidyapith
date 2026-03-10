JAVA = ('MCA101', 'Dr.Kamlesh Saluke')
Python = ('MCA103', 'Dr.Ajay Parikh')
DS = ('MCA102', 'Neepa Shah')
DBMS = ('MCA104', 'Dr.Dhiren Patel')

enrollments = {
    JAVA: set(),
    Python: set(),
    DS: set(),
    DBMS: set()
}

choice = 1
while choice != 0:
    choice = int(input('Want to add new student [0 -> No , 1 -> Yes]: '))
    if choice == 0:
        break

    studName = input("Enter the student name: ")
    EnrolledSubject = int(input("Enter the subject student enrolled in [1 -> JAVA , 2 -> Python , 3 -> DS , 4 -> DBMS]: "))

    if EnrolledSubject == 1:
        course = JAVA
    elif EnrolledSubject == 2:
        course = Python
    elif EnrolledSubject == 3:
        course = DS
    elif EnrolledSubject == 4:
        course = DBMS
    else:
        print("Invalid subject choice.")
        continue

    if studName in enrollments[course]:
        print(f"Student '{studName}' already enrolled in {course}!")
    else:
        enrollments[course].add(studName)
        print(f"Added '{studName}' to {course}")

print("\n--- Enrollments ---")
for course, students in enrollments.items():
    print(f"Available Course: {course}")
    print(f"Enrolled Students: {students}\n")
