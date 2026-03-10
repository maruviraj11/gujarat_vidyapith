import java.util.Scanner;
public class utill {

    Scanner sc=new Scanner(System.in);
    public  static long factorial(long val)
    {
        long  i;
        long fact=1;

      
        for(i=1;i<val;i++)
        {
           fact =fact*i;
           
        }

        return fact;
    }
    public static void main(String args[])
    {
        System.out.println("factoriyal is...!"+utill.factorial(5));
    }

    
}
