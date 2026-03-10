// import java.util.Scanner;
class oddThread extends Thread
{
    public void run()
    {
        try{
            for(int i=0;i<=100;i++)
             {
                if(i%2==0)
                {
                    System.out.println(i);
                    Thread.sleep(900);
            
                }
            }

        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
        
    }
}
class primeThread implements Runnable
{
    public void run()
    {
        try{
            for(int i=0;i<=100;i++)
             {
                if(i%2!=0)
                {
                    System.out.println(i);
                    Thread.sleep(1000);
                }
             }
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
class multhread
{
    public static void main(String[] args) 
    {
        oddThread odd=new oddThread();
        primeThread prime =new primeThread();
        Thread th=new Thread(prime);

        odd.start();
        th.start();
    }
}