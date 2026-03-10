//Q-2 Write a program that reads five integer numbers from the command line, 
//sorts them, and then displays the minimum and maximum values.

import java.util.*;
public class minmax {

    public static void main(String[] args) {

        try{
            if(args.length!=5)
            {
                throw new ArrayIndexOutOfBoundsException();
            }
            else
            {
                System.out.println("Entered numbers before sorting...");

                int[] num = new int[5];

                for (int i = 0; i < args.length; i++) {
                    num[i] = Integer.parseInt(args[i]);
                    System.out.print("  " + args[i]);
                }

                Arrays.sort(num);

                System.out.println("\nNumbers after sorting...");

                for (int i = 0; i < 5; i++) {
                    System.out.print("  " + num[i]);
                }

                System.out.println("\nMinmum value : " + num[0]);
                System.out.println("Maximum value : " + num[num.length - 1]);
            }
        }catch(ArrayIndexOutOfBoundsException e)
        {
            System.err.println("Enter five values.!!");
        }catch(NumberFormatException e){
            System.out.println("Enter only numbers!!");
        }
    }

}