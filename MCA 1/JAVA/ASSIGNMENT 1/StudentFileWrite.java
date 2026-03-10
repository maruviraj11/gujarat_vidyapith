import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileWrite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "student.txt";

        try {
            FileWriter fw = new FileWriter(fileName, true); 

            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            sc.nextLine(); 

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for Student " + i + ":");

                System.out.print("Roll Number: ");
                int roll = sc.nextInt();
                sc.nextLine(); 

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Marks in Subject 1: ");
                int m1 = sc.nextInt();
                System.out.print("Marks in Subject 2: ");
                int m2 = sc.nextInt();
                System.out.print("Marks in Subject 3: ");
                int m3 = sc.nextInt();
                sc.nextLine();

                
                fw.write(roll + "\t" + name + "\t" + m1 + "\t" + m2 + "\t" + m3 + "\n");

                

            fw.close();
            System.out.println("\n Data successfully saved to " + fileName);

        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }

        sc.close();
    }
}
