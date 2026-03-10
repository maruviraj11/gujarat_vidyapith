import java.util.Scanner;
class oddThread extends Thread
{
    public void run()
    {
            try
             {
                for(int i=0;i<=100;i++)
                {
                    if(i%2!=0)
                    {
                        System.out.println("ODD NO IS.."+i);
                        Thread.sleep(500);
                    }
                }
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
    }
        
}
    
class prime implements Runnable
{
 
    private boolean isPrime(int n)
    {
        if(n<=1)
            return false;
    
        for(int i=2;i<=n/2;i++)
        {
            if(n%2==0)
            {
                return false;
            }
            
            
        }
        return true;
    }
    public void run()
    {
        
        try
        {
            for(int i=0;i<=100;i++)
            {
                if(isPrime(i))
                {
                    System.out.println("PRIME NO IS "+i);
                    Thread.sleep(1000);
                }
            }
        }
     catch(InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
 }

public class p13 {

    public static void main(String args[])
    {
        oddThread o1=new oddThread();
        prime p1=new prime();
        Thread t1=new Thread(p1);

        o1.start();
        t1.start();
    }
}
