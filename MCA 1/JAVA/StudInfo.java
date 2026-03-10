import java.util.*;

class Student {
    public void displayDetails(String name, int rollNo, float marks) {
        System.out.println("----Student Details----");
        System.out.println("Name : " + name);
        System.out.println("Roll No. : " + rollNo);
        System.out.println("Marks : " + marks);
    }
}

class StudInfo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            Student st = new Student();

            System.out.print("Enter the student name : ");
            String name = sc.nextLine();

            System.out.print("Enter the student roll no : ");
            int rollNo = sc.nextInt();
            if (rollNo <= 0) {
                throw new IllegalArgumentException("Roll number must be a positive integer.");
            }

            System.out.print("Enter the student marks : ");
            float marks = sc.nextFloat();
            if (marks < 0 || marks > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100.");
            }

            st.displayDetails(name, rollNo, marks);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data type.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
        sc.close();
    }
}
