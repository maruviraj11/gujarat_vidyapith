# College Course Enrolment System (Choice-based)

# Dictionary: course_code → {details: (course_code, faculty), students: set()}
courses = {
    "CS101": {"details": ("CS101", "Dr. Mehta"), "students": set()},
    "MA101": {"details": ("MA101", "Prof. Rao"), "students": set()},
    "PH101": {"details": ("PH101", "Dr. Sharma"), "students": set()}
}

# Function to add a student
def add_student(course_code, student_name):
    if course_code in courses:
        courses[course_code]["students"].add(student_name)   # set avoids duplicates
        print(f" Added '{student_name}' to {course_code}")
    else:
        print(" Course not found!")

# Function to display all courses and enrolled students
def display_courses():
    for code, data in courses.items():
        course_code, faculty = data["details"]   # tuple unpacking
        print(f"\nCourse: {course_code}, Faculty: {faculty}")
        if data["students"]:
            print("Enrolled Students:", data["students"])
        else:
            print("No students enrolled yet.")

# ---------------- MENU ----------------
while True:
    print("\n===== College Course Enrolment System =====")
    print("1. Add Student to a Course")
    print("2. Display All Courses and Students")
    print("3. Exit")

    choice = input("Enter your choice (1-3): ")

    if choice == "1":
        course = input("Enter course code (CS101/MA101/PH101): ")
        student = input("Enter student name: ")
        add_student(course, student)
    elif choice == "2":
        display_courses()
    elif choice == "3":
        print(" Exiting... Goodbye!")
        break
    else:
        print("⚠️ Invalid choice! Please enter 1, 2, or 3.")
