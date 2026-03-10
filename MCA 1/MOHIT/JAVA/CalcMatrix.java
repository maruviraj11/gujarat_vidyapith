//matrix multiplication with exception handling
import java.util.*;

public class CalcMatrix {
    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in); 
        int matrix1[][] = new int[3][3];
        int matrix2[][] = new int[3][3];
        int matrix3[][] = new int[3][3];

        System.out.println("Enter elements in First Matrix (3x3):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                while (true) {
                    try {
                        System.out.print("Element [" + (i+1) + "][" + (j+1) + "]: ");
                        matrix1[i][j] = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter a valid integer!");
                        sc.next();
                    }
                }
            }
        }

        System.out.println("\nEnter elements in Second Matrix (3x3):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                while (true) {
                    try {
                        System.out.print("Element [" + (i+1) + "][" + (j+1) + "]: ");
                        matrix2[i][j] = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter a valid integer!");
                        sc.next();
                    }
                }
            }
        }

        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix3[i][j] = 0; 
                    for (int k = 0; k < 3; k++) {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            System.out.println("\nResult of Matrix Multiplication:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
        } catch (Exception e) {
            System.out.println("Error during matrix multiplication: " + e.getMessage());
        }
    }
}
