class person:

    def __init__(self,name,age):
        self.name=name
        self.age=age

    def intro(self,marks1=90,marks2=80):
        self.marks1=marks1
        self.marks2=marks2
        

    def get(self):
        print("hello mr...",self.name)
        print("my age is..",self.age)


p1=person("viraj",21)
p1.intro()
p1.get()

print("marks one is..",p1.marks1)
print("marks sec is..",p1.marks2)



    
