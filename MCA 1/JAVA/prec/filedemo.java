import java.io.File;
import java.io.IOException;

public class filedemo {

    public static void  main(String[] args)
    {
        try{
                File objFile= new File("college.txt");

        if(objFile.createNewFile())
        {
            System.out.println("file craeted successfully...");

        }
        else{
            System.out.println("file already exits..");
        }

        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
}