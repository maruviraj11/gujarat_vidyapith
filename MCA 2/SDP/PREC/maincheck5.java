import multipleornot.checkno5;
import java.util.Scanner;
public class maincheck5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        System.out.println("ENTER A ANY NUMBER:");
        int n=sc.nextInt();

        checkno5 c1=new checkno5();

       boolean check_number= c1.checkno(n);

       if (check_number==true) {

         System.out.println("NO IS MULTIPLE OF 5:"+n);
        
       }
       else
       {
        System.out.println("NO IS  NOT MULTIPLE OF 5:"+n);
       }

        sc.close();
    }
    
}
