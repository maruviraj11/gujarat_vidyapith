
public class threaddemo extends Thread {
    public void run()
    {
        for(int i=0;i<=5;i++)
        {
            System.out.println("thread is:"+i);
        }
    }
    
}
class thread {
    public static void main(String args[])
    {
        threaddemo t1=new threaddemo();
        t1.start();
    }
}