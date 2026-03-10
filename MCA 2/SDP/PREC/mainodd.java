import oddevenno.oddeven;
import java.util.Scanner;
public class mainodd {

        public static void main(String args[])
        {
                Scanner sc=new Scanner(System.in);

                oddeven o1=new oddeven();

                System.out.println("ENTER A ANY NUMBER:");
                int z=sc.nextInt();

                boolean check_number =  o1.checkno(z);

                if(check_number == true)
                {
                        System.out.println("Number is Even");
                }
                else
                {
                        System.out.println("Number is Odd");
                }

                sc.close();
        }
        
}
        
       