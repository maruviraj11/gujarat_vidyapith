import cal.add;
import java.util.Scanner;

public class main1 {

    public static void main(String args[])
    {

        Scanner sc=new Scanner(System.in);
        add a=new add();
        

        System.out.println("ENTER A ANY NUMBER:");
        int x=sc.nextInt();

        System.out.println("ENTER A ANY NUMBER:");
        int y=sc.nextInt();

        System.out.println("ADDITION IS:"+a.addno(x,y));
        System.out.println("SUBTRACTION IS:"+a.sub(x,y));

        sc.close();


    }

    
}
