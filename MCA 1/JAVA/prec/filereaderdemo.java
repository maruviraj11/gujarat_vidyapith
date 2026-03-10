import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filereaderdemo {

    public static void main(String[] args)
    {
        File obj =new File("college.txt");
        try(Scanner myReader=new Scanner(obj)){

            while (myReader.hasNextLine()) {
                String data=myReader.nextLine();
                System.out.println(data);
                
            }
        }catch(FileNotFoundException e)
        {
            System.out.println("file reader error..."+e.getMessage());
        }
    }
}