import java.util.*;
class Student
{
    public void displayDetails(String name, int rollNo, float marks)
    {
        System.out.println("----Student Details----");
        System.out.println("Name : "+ name);
        System.out.println("roll No. : "+ rollNo);
        System.out.println("Marks : "+ marks);
    }
}
class StudInfo
{
    public static void main(String args[])
    {
        Student st = new Student();
        Scanner sc = new Scanner(System.in);
        int rollNo,marks;
        String name;

        System.out.print("Enter the student name : ");
        name=sc.nextLine();
        System.out.print("Enter the student roll no : ");
        rollNo=sc.nextInt();
        System.out.print("Enter the student marks : ");
        marks=sc.nextInt();

        st.displayDetails(name, rollNo, marks);
    }
}