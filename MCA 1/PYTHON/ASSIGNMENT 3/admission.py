class AgeError(Exception):
    pass

class CourseError(Exception):
    pass

def validate_age(func):
    def wrapper(self, form):
        if form.age < 17 or form.age > 30:
            raise AgeError("Invalid age! Must be 17 to 30.")
        return func(self, form)
    return wrapper

class AdmissionForm:
    def __init__(self, name, age, course):
        self.name = name
        self.age = age
        self.course = course

def course_checker():
    allowed = ["BCA", "BBA", "BSC", "BA"]
    def check(course):
        if course not in allowed:
            raise CourseError("Invalid Course! Choose from: " + ", ".join(allowed))
        return True
    return check

class AdmissionOffice:
    def __init__(self):
        self.forms = []
        self.check_course = course_checker()

    @validate_age
    def add_form(self, form):
        self.check_course(form.course)
        self.forms.append(form)
        print("Form added successfully.")

    def display(self):
        if not self.forms:
            print("No forms found.")
        else:
            print("\n--- Admission Forms ---")
            for f in self.forms:
                print(f"Name: {f.name}, Age: {f.age}, Course: {f.course}")

office = AdmissionOffice()

while True:
    name = input("\nEnter name: ")
    age = int(input("Enter age: "))
    course = input("Enter course (BCA/BBA/BSC/BA): ").upper()

    form = AdmissionForm(name, age, course)

    try:
        office.add_form(form)
    except AgeError as e:
        print(e)
    except CourseError as e:
        print(e)

    more = input("Add another? (yes/no): ").lower()
    if more != "yes":
        break

office.display()
