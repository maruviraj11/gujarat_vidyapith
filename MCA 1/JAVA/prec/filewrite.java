import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class filewrite
{
    public static void main(String[] args)
    {
      try{
         FileWriter mywriter=new FileWriter("viraj.txt");

        mywriter.write("hy this is viraj here....");
        mywriter.close();

        System.out.println("this file was writen successfully....");

      }catch(IOException e)
      {
        System.out.println("write error exception..."+e.getMessage());
      }
       

    }
}