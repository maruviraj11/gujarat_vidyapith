import java.util.Scanner;


class prestd{
   


    // String name;
    // int rollno;
    // float marks;


   public  void display()
   {

    
        System.out.println("\n STUDENT INFORMATION ");   
        System.out.println("\nSTUDENT NAME IS :"+name);
        System.out.println("\nSTUDENT ROLLNO:"+rollno);
        System.out.println("\n STUDENT MARKS:"+marks);

   }
   public static void main(String[] args)
   {
     Scanner sc=new Scanner(System.in);

    System.out.println("ENTER A STUDENT NAME");
    String name=sc.nextLine();

    System.out.println("ENTER A ROLLNO ");
    int rollno=sc.nextInt();

    System.out.println("ENTER A STUDENT MARKS");
    float marks =sc.nextFloat();

    student s1=new student();

    // s1.name="viraj";
    // s1.rollno=52;
    // s1.marks=90.65f;

    s1.display();

   }



    
}