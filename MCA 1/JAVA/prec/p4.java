import java.util.Scanner;

class matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 0, cols = 0;

        try {
            // Input dimensions
            System.out.print("Enter the number of rows: ");
            rows = Integer.parseInt(sc.nextLine());

            System.out.print("Enter the number of columns: ");
            cols = Integer.parseInt(sc.nextLine());

            double[][] m1 = new double[rows][cols];
            double[][] m2 = new double[rows][cols];
            double[][] sum = new double[rows][cols];
            double[][] diff = new double[rows][cols];
            double[][] prod = new double[rows][cols];

            // Input Matrix A
            System.out.println("Enter the elements of A matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("A[" + i + "][" + j + "]: ");
                    m1[i][j] = Double.parseDouble(sc.nextLine());
                }
            }

            // Input Matrix B
            System.out.println("Enter the elements of B matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("B[" + i + "][" + j + "]: ");
                    m2[i][j] = Double.parseDouble(sc.nextLine());
                }
            }

            // Perform addition, subtraction
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sum[i][j] = m1[i][j] + m2[i][j];
                    diff[i][j] = m1[i][j] - m2[i][j];
                }
            }

            // Perform multiplication
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    prod[i][j] = 0;
                    for (int k = 0; k < cols; k++) {
                        prod[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }

            // Display results
            System.out.println("\nThe Addition of the two matrices is:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print((int)sum[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nThe Subtraction of the two matrices is:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print((int)diff[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nThe Multiplication of the two matrices is:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print((int)prod[i][j] + " ");
                }
                System.out.println();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}