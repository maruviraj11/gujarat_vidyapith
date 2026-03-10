cou={
    'py101':('py101','dr.parikh'),
    'java':('java201','dr.saluke'),
    'ds301':('ds301','dr.nipa')

}
enr={
    'py101':set(),
    'java201':set(),
    'ds301':set()
}

def dis():

    for c_code,stud in enr.items():
        c_info=cou[c_code]

        print("couses info ",c_info)

        if stud  in enr[coures]:
            print("student is noe enrolled")
        else:
            enr[coures]=add_s[student]
            print("student is enrolled")

def add_s(coures,student):

    if coures in cou:
        print("cource is allredy ..")
    if student in enr[coures]:
        print("student is allredy in data..")
    else:
        enr[coures]=add_s[student]
        print("successfully...")



while True:
     ch=int(input("Enter a  any number:"))

     if ch==1:
         dis()
     if ch==2:
         coures=input("enter a any course")
         student=input("enter a student name")
         add_s(coures,student)
     if ch==3:
         exit()
         break
      
    
    
        