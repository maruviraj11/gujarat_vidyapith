package pack;
public class marks {
    
    int m1,m2,m3;
    public void setdata(int m1,int m2,int m3)
    {

        this.m1=m1;
        this.m2=m2;
        this.m3=m3;

    }
    public void display()
    {

        System.out.println("\n-------STUDENT MARKSHEET-----------");
        System.out.println("\n-----------------------------------");
        System.out.println("\nSTUDENT FIRST SUBJECT MARKS IS..."+m1);
        System.out.println("\nSTUDENT SECOUND SUBJECT MARKS IS.."+m2);
        System.out.println("\nSTUDENT THIRED SUBJECT MARKS IS..."+m3);

    }

}
