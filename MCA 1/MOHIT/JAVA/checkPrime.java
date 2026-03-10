/* Que.1 get integer number, check wether it's prime number, use loop, if else condition, break statement,
 continue statement
 */
import java.util.*;
import java.util.Scanner;

public class checkPrime
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int val=0,flag=0;
        int i;

        try
        {
            //getting input from the user
            System.out.print("\nEnter any number to check whether it is prime number or not: ");
            val = sc.nextInt();
        }catch(InputMismatchException e)
        {
            System.out.println("Enter valid input!!");
        }
        finally
        {
        
            for(i = 2; i <= val/2; i++)        //For Loop
            {
                if(val % i == 0)               //If-else statement
                {
                    flag=1;
                    break;                     //break statement  
                }else{
                    continue;                  //continue statement
                }
            }

            //Condition to check for prime number
            if(flag==0 && val>=2)
            {
                System.err.println(val + " is a prime number.");
            }
            else{
                System.err.println(val + " is not a prime number.");
            }
            sc.close();
        }
    }
}