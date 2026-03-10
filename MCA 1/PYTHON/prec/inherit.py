class Person:
  def __init__(self, fname, lname):
    self.firstname = fname
    self.lastname = lname

  def printname(self):
    print(self.firstname, self.lastname)

#Use the Person class to create an object, and then execute the printname method:

x = Person("viraj", "Doe")
x.printname()

# c
class Student(Person):
  def __init__(self, fname, lname,year):
    super.__init__(self, fname, lname)
