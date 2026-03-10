import div.checkno;
import java.util.Scanner;
public class main3or5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a any number..");
        int n=sc.nextInt();


        checkno c1=new checkno();

        boolean check_number=c1.check(n);

        if (check_number==true) {

            System.err.println("NO IS DIVISION BY 3 OR 5..:"+n);
            
        }
        else
        {
            System.err.println("NO IS NOT  DIVISION BY 3 OR 5..:"+n);
        }

        sc.close();
    }
    
}
