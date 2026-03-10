import java.util.Scanner;
class NegativeValueException extends Exception {
    public NegativeValueException(String message) {
        super(message);
    }
}

public class CheckNumber {
    public static void main(String[] args) {
        try {
            for (String arg : args) {
                int num = Integer.parseInt(arg); 

                if (num < 0) {
                    
                    throw new NegativeValueException("Negative value found: " + num);
                } else {
                    System.out.println(num + " is positive.");
                }
            }
        } catch (NegativeValueException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter only numbers.");
        }
    }
}
