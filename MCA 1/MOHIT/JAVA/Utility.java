import java.util.*;
class Utility
{
    public static long factorial(long value)
    {
        if(value == 0 || value == 1)
        {
            return 1;
        }
        else
        {
            return value * factorial(value - 1);
        }
    }
    public static boolean isPrime(int value)
    {
        int i,flag = 0;
        if(value < 2)
        {
            flag = 0;
        }
        else{
            
            for(i = 2; i <= value/2;i++)
            {
                if(value % i == 0)
                {
                    flag = 0;
                    break;
                }
                else{
                    flag = 1;
                }
            }
            if(flag == 0)
            {
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public static boolean isEven(long value)
    {
        if(value % 2 == 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isOdd(long value)
    {
        if(value % 2 == 1)
        {
            return true;
        }
        else{
            return false;
        }
    }
}

class Utility_Program{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        long value1;
        System.out.println("---List of Operations---");
        System.out.println("1.factorial \n 2.isPrime \n 3.isEven \n 4.isOdd\nEnter Choice:");
        choice = sc.nextInt();
        
        switch(choice)
        {
            case 1:
                System.out.println("Enter value in to check its factorial:");
                value1 = sc.nextLong();
                long return_value = Utility.factorial(value1);
                System.out.println("The factorial of given value is:"+return_value);
                break;

            case 2:
                System.out.println("Enter value in to check its prime or not:");
                int value = sc.nextInt();
                if(Utility.isPrime(value))
                {
                    System.out.println("Number is not Prime number");
                }
                else
                {
                    System.out.println("Number is prime number");
                }
                break;

            case 3:
                System.out.println("Enter value in to check its even number or not:");
                value1 = sc.nextLong();
                if(Utility.isEven(value1))
                {
                    System.out.println("Number is Even number");
                }
                else
                {
                    System.out.println("Number is not Even number");
                }
                break;
            
                case 4:
                    System.out.println("Enter value in to check its Odd number or not:");
                value1 = sc.nextLong();
                if(Utility.isOdd(value1))
                {
                    System.out.println("Number is Odd number");
                }
                else
                {
                    System.out.println("Number is not Odd number");
                }
                break;
            default:
                System.out.println("Enter valid input!!");
                break;
        }
        
        
    }
}