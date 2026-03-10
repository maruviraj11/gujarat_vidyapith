courses = {
    'PY101' : ('PY101','Udemy'),
    'JAVA201' : ('JAVA201','Coursera'),
    'DS303' : ('DS303','upGrade')
}

enrolled = {
    'PY101' : ['Anis','Naresh'],
    'JAVA201' : [],
    'DS303' : []
}

def display_record():
    for course_code,student in enrolled.items():
        course_info= courses[course_code]
        print("Course Info ",course_info)

        if student:
            print(f"Enrolled Student {student}")
        else:
            print("not student enrolled")

        # print(f"Enrolled Student {student}" if student else "not student enrolled")

def add_student(course,student):
    if course not in courses:
        print("Course is Not Available")
        return

    if student in enrolled[course]:
        print("Already Existing Student")
    else:
        enrolled[course].append(student)
        print("Successfully Enrolled Student")
        
    
while True:
    print("1. Display Records ")
    print("2. Add Students to Course")
    print("3. Exit")

    
    try:
        ch = int(input("Enter Choice :"))

        if ch==1:
            display_record()
        elif ch==2:
            course=input("Enter Course Name : ").upper()
            student=input("Enter Student Name :")
            add_student(course,student)#call
        elif ch==3:
            print("Exit")
            break
        else:
            print("Invalid Choice")
    except Exception as e:
        print("ENTER VALID INPUT")

        
    
   
   

# print(courses.items())

#  x,y = [1,2]

#  print(x)
#  print(y)