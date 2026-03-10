import java.util.Scanner;

class mat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 0, cols = 0;

        try {
            // Input dimensions with validation
            while (true) {
                try {
                    System.out.print("Enter the number of rows: ");
                    rows = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter the number of columns: ");
                    cols = Integer.parseInt(sc.nextLine());

                    if (rows <= 0 || cols <= 0) {
                        System.out.println("Rows and columns must be positive integers!");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter integers only.");
                }
            }

            double[][] m1 = new double[rows][cols];
            double[][] m2 = new double[rows][cols];
            double[][] sum = new double[rows][cols];
            double[][] diff = new double[rows][cols];
            double[][] prod = new double[rows][cols];

            // Input Matrix A with validation
            System.out.println("Enter the elements of Matrix A:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    while (true) {
                        try {
                            System.out.print("A[" + i + "][" + j + "]: ");
                            m1[i][j] = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }
                }
            }

            // Input Matrix B with validation
            System.out.println("Enter the elements of Matrix B:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    while (true) {
                        try {
                            System.out.print("B[" + i + "][" + j + "]: ");
                            m2[i][j] = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }
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
            printMatrix(sum);

            System.out.println("\nThe Subtraction of the two matrices is:");
            printMatrix(diff);

            System.out.println("\nThe Multiplication of the two matrices is:");
            printMatrix(prod);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Helper method to print matrix
    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print((int) val + " ");
            }
            System.out.println();
        }
    }
}
