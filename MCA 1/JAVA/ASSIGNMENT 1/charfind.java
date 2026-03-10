//import java.util.Scanner;
import java.util.Scanner;
class charfind {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try { 

            System.out.println("Enter any string:");
            String inputStr = sc.nextLine();

            System.out.println("Enter the character to find:");
            String charInput = sc.nextLine();

            if (charInput.length()!=1) {
                throw new Exception("Error: Please enter atlist one character.");
                //return;
            }

            char targetChar = charInput.charAt(0);

            int count = 0;
            boolean found = false;
            
            for (int i = 0; i < inputStr.length(); i++) {
                if (inputStr.charAt(i) == targetChar) {
                    if(found == false){
                        System.out.print("Character '" + targetChar + "' found at indices: ");
                        found = true;
                    }
                    count++;
                    System.out.print(i + " ");
                }
            }
            
            if (count > 0) {
                System.out.println("\nFrequency of '" + targetChar + "' = " + count);
            } else {
                throw new Exception("Character '" + targetChar + "' not found in the string.");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("THIS PROGRAM WAS SUCESSFULLY CLOSED....");
        }
    }
}