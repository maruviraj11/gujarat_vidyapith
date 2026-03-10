package div;
public class checkno {

    
    public boolean check(int a)
    {
        if(a%3==0 && a%5==0)
        {
           // System.err.println("NO IS DIVISION BY 3 OR 5..:"+a);

           return true;
        }
        else
        {
           // System.out.println("NO IS NOT DIVISION BY 3 OR 5..:"+a);
           return false;
        }
    }
}