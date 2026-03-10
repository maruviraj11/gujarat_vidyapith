import java.util.Scanner;


class student{
    Scanner sc=new Scanner(System.in);


   /*  System.out.println("ENTER A STUDENT NAME");
    string name=sc.nextLine();

    System.out.println("ENTER A ROLLNO ");
    int rollno=sc.nextInt();

    System.out.println("ENTER A STUDENT MARKS");
    float marks =sc.nextFloat();*/


    String name;
    int rollno;
    float marks;


   public  void display()
   {
        System.out.println("\n STUDENT INFORMATION ");   
        System.out.println("\nSTUDENT NAME IS :"+name);
        System.out.println("\nSTUDENT ROLLNO:"+rollno);
        System.out.println("\n STUDENT MARKS:"+marks);

   }
   public static void main(String[] args)
   {

    student s1=new student();
    try{
        s1.name="viraj";
        s1.rollno=52;
        s1.marks=90.65f;
    }
    catch(Exception e)
    {
        System.out.println("EXCEPTION:pleace enter valid data.."+e.getMessage());
    }
    finally{
        System.out.println("YOUR PROGRAM WAS SUCCESSFULLY RUN..");
    }
    

    s1.display();

   }



    
}