class dog:

    def __init__(self,n,a):
        self.n=n
        self.a=a
    
    def intro(self):

        return f"name:{self.n},age:{self.a}"
    
n=input("enter a dog name:")
a=int(input("enter a dog age:"))

d1=dog(n,a)
print(d1.intro())