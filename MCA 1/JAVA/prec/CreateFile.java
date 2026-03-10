// import java.io.File;       // Import the File class
// import java.io.IOException; // Import IOException to handle errors

// public class CreateFile {
//   public static void main(String[] args) {
//     try {
//       File myObj = new File("filename.txt"); // Create File object
//       if (myObj.createNewFile()) {           // Try to create the file
//         System.out.println("File created: " + myObj.getName());
//       } else {
//         System.out.println("File already exists.");
//       }
//     } catch (IOException e) {
//       System.out.println("An error occurred.");
//       e.printStackTrace(); // Print error details
//     }
//   }
// }

import java.io.File;
import java.io.IOException;

class CreateFile{

  public static void main(String[] args)
  {
    File obj=new File("viraj.txt");
    try
    {
       if(obj.createNewFile())
    {
      System.out.println("file created successfully..."+obj.createNewFile());
    }
    else
    {
      System.out.println("file already exits...");
    }

    }catch(IOException e)
    {
      System.out.println("FILE EXCEPTION ERROR..."+e.getMessage());
    }
   
  }
}