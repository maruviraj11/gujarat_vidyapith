//import java.io.file;
import java.io.IOException;
import java.io.FileWriter;

public class filewritedemo {

    public static void main(String[] args)
    {
        
        try{
            FileWriter obj=new FileWriter("college.txt");

            obj.write("hy this is viraj here and this this a file handling progam... ");
            obj.close();

            System.out.println("file write seccuussfully....");

        }
        catch(IOException e)
        {
            System.out.println("exception file not reasponding..."+e.getMessage());
        }
    }
}