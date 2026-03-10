import java.util.Scanner;
public class stud {
    
        public void display(int rollno,String name,float marks )
        {
            System.out.println("-------Student information-------");
            System.out.println("Student rollno is: "+rollno);
            System.out.println("Student name is: "+name);
            System.out.println("Student marks is: "+marks);
        }
        public int  mar(int m1,int m2,int m3)
        {
                System.out.println("--------marks sheet------");
                System.out.println("python"+m1);
                System.out.println("java"+m2);
                System.out.println("ds"+m3);
                return m1;
        }
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);

            System.out.println("Enter a student name:");
            String name=sc.nextLine();

            System.out.println("Enter a student rollno");
            int rollno=sc.nextInt();

            System.out.println("Enter a student marks");
            float marks=sc.nextFloat();

            stud s1=new stud();

           // s1.display(52,"Vira Maru",96.22f);
           s1.display(rollno,name,marks);
           s1.mar(100,50,65);


        }
}
