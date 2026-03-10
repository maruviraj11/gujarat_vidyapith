// Utility.java
class Utility {

 
    public static long factorial(long value){ //throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long fact = 1;
        for (long i = 1; i <= value; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static boolean isPrime(int value){// throws IllegalArgumentException {
        if (value < 0) {
            throw new IllegalArgumentException("Prime check is not valid for negative numbers.");
        }
        if (value <= 1) {
            return false;
        }
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false; // not prime
            }
        }
        return true; // prime
    }

  
    public static boolean isEven(long value) {
        return value % 2 == 0;
    }

   
    public static boolean isOdd(long value) {
        return value % 2 != 0;
    }
}
public class Main {
    public static void main(String[] args) {
        try {
           
            System.out.println("Factorial of 5: " + Utility.factorial(5));
         
            System.out.println("Factorial of -3: " + Utility.factorial(-3));

        } catch (IllegalArgumentException e) {
            System.out.println("Error in factorial: " + e.getMessage());
        }

        try {
           
            System.out.println("Is 7 prime? " + Utility.isPrime(7));
            
            System.out.println("Is -5 prime? " + Utility.isPrime(-5));

        } catch (IllegalArgumentException e) {
            System.out.println("Error in prime check: " + e.getMessage());
        }

      
        System.out.println("Is 8 even? " + Utility.isEven('8'));
        System.out.println("Is 11 odd? " + Utility.isOdd(11));
    }
}
