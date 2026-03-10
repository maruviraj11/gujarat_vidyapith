import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class p14 {

    
    public static void main(String args[])
    {
        try {

            Scanner sc =new Scanner(System.in);
            String filename="virajmaru.txt";
            FileWriter fw=new FileWriter(filename,true);

            System.out.println("----------student details----------");
            sc.nextLine();

            System.out.println("Enter your name");
            String name=sc.nextLine();

            System.out.println("Enter your rollno..");
            int roll=sc.nextInt();

            sc.nextLine();


            System.out.println("Enter first subject marks");
            int m1=sc.nextInt();

            sc.nextLine();
            System.out.println("Enter secound subject marks");
            int m2=sc.nextInt();

            sc.nextLine();

            System.out.println("Enter first subject marks");
            int m3=sc.nextInt();

            sc.nextLine();

            fw.write(roll+"\t"+ name +"\t"+m1 +"\t"+m2+"\t"+m3+"\t");

            fw.close();
            System.out.println("data successfully save in virajmaru.txt");
            
    } catch (IOException e) {
        System.out.println(e.getMessage());
        
    }

      //sc.close(); 
    }
}