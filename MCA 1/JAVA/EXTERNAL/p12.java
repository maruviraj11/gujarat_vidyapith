import java.util.Scanner;
class NegativeValueException extends Exception
{
    public NegativeValueException(String message)
    {
        super(message);
    }
}
public class p12 {

     public static void main(String[] args) {
        
        
            try
            {
                for(String arg : args)
                 {
                    int num=Integer.parseInt(arg);
                    if(num<0)
                    {
                        throw new NegativeValueException("nagative value is"+num);
                    }
                    else
                    {
                        System.out.println("positive value is.."+num);
                    }
                 }
            }
            catch(NegativeValueException e)
            {
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException e)
            {
                System.out.println(e.getMessage());
            }
           
        
     }
}