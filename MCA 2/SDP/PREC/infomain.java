import pack.student;
import pack.marks;
import pack.totalmarks;
import java.util.Scanner;
public class infomain {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        student s1= new student();
        marks ma1=new marks();
        totalmarks t1=new totalmarks();

        System.out.println("Enter a stduent name:");
        String name=sc.nextLine();

        System.out.println("Enter a student rollno:");
        int roll=sc.nextInt();

        sc.nextLine();

        System.out.println("Enter a student course..:");
        String cou=sc.nextLine();

        System.out.println("ENTER A SUBJECT MARKS");
        int m1=sc.nextInt();

        System.out.println("ENTER A SUBJECT MARKS");
        int m2=sc.nextInt();

        System.out.println("ENTER A SUBJECT MARKS");
        int m3=sc.nextInt();



        s1.setdata(name,roll,cou);
        s1.display();

        ma1.setdata(m1,m2,m3);
        ma1.display();


        t1.setdata(m1,m2,m3);
        double per=t1.sum();

        System.out.println("\nSTUDENT FINAL PER IS..."+per);

        

        sc.close();

    }

}
