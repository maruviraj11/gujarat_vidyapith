class person:
    def __init__(self,name,age=18):
        self.name=name
        self.age=age
     # def getmethod(self):
        # print("hello ",self.name)
class get:
    def __init__(self,name,age):
        self.name=name
        self.age=age

p1=person("viraj")
p2=get("jay",22)
print(p1.name)
print(p1.age)
print(p2.name)
print(p2.age)

#p1.getmethod()