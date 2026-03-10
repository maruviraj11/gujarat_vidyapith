/*Write a program that accepts a string and a character as input. The program should print
the frequency of the character in the string and list all the positions (indices) where 
the character appears.*/

import java.util.*;

public class freq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name : ");
        String s = sc.nextLine();

        System.out.print("Enter the character name : ");
        char ch = sc.next().charAt(0);
        
        try {
                if(s.length() < 1)
                {
                    throw new NullPointerException();
                }
                else{
                    int count = 0;
        System.out.println("Entered String : "+s);
        System.out.println("\nCharacter to be check : " + ch);
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        System.out.println("\nFrequency of the character: " + count);
        sc.close();
                }
        } catch (NullPointerException e) {
            System.out.println("Enter a string first!!");
        }
    }
}