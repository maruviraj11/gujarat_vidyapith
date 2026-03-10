import java.util.Scanner;
class goodmorning extends Thread
{
    public void run()
    {
        try
        {
            for(int i=0;i<=100;i++)
            {
                System.out.println("GOOD MORING ..");
                Thread.sleep(1000);
            }
           
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }        
    }
}
class hello implements Runnable
{
    public void run()
    {
        try{
            for(int i=0;i<=100;i++)
            {
                System.out.println("HELLO ...");
                Thread.sleep(1200);
            }
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
public class multhread2 {

    public static void main(String[] args)
    {
        goodmorning g1=new goodmorning();
        hello h1= new hello();
        Thread t1=new Thread(h1);

        g1.start();
       // h1.start();
        t1.start();
    }
}