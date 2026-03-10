public class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    // Constructor for empty matrix with specified dimensions
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Constructor with initial 2D array
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    // Copy constructor
    public Matrix(Matrix other) {
        this.rows = other.rows;
        this.cols = other.cols;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = other.data[i][j];
            }
        }
    }

    // Transpose of the matrix
    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    // Addition with another matrix
    public Matrix addition(Matrix m1) {
        if (this.rows != m1.rows || this.cols != m1.cols) {
            throw new IllegalArgumentException("Matrices must have same dimensions for addition");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + m1.data[i][j];
            }
        }
        return result;
    }

    // Static addition of two matrices
    public static Matrix addition(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.cols != m2.cols) {
            throw new IllegalArgumentException("Matrices must have same dimensions for addition");
        }
        Matrix result = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                result.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }

    // Subtraction with another matrix
    public Matrix subtraction(Matrix m1) {
        if (this.rows != m1.rows || this.cols != m1.cols) {
            throw new IllegalArgumentException("Matrices must have same dimensions for subtraction");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - m1.data[i][j];
            }
        }
        return result;
    }

    // Static subtraction of two matrices
    public static Matrix subtraction(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.cols != m2.cols) {
            throw new IllegalArgumentException("Matrices must have same dimensions for subtraction");
        }
        Matrix result = new Matrix(m1.rows, m1.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                result.data[i][j] = m1.data[i][j] - m2.data[i][j];
            }
        }
        return result;
    }

    // Multiplication with another matrix
    public Matrix multiplication(Matrix m1) {
        if (this.cols != m1.rows) {
            throw new IllegalArgumentException("Number of columns of first matrix must equal number of rows of second matrix");
        }
        Matrix result = new Matrix(this.rows, m1.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m1.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * m1.data[k][j];
                }
            }
        }
        return result;
    }

    // Static multiplication of two matrices
    public static Matrix multiplication(Matrix m1, Matrix m2) {
        if (m1.cols != m2.rows) {
            throw new IllegalArgumentException("Number of columns of first matrix must equal number of rows of second matrix");
        }
        Matrix result = new Matrix(m1.rows, m2.cols);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m2.cols; j++) {
                for (int k = 0; k < m1.cols; k++) {
                    result.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }

    // Inverse of the matrix (for square matrices)
    public Matrix inverse() {
        if (rows != cols) {
            throw new IllegalArgumentException("Matrix must be square for inverse");
        }
        int n = rows;
        Matrix augmented = new Matrix(n, 2 * n);
        
        // Create augmented matrix [A|I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmented.data[i][j] = this.data[i][j];
            }
            augmented.data[i][i + n] = 1.0;
        }

        // Gaussian elimination
        for (int i = 0; i < n; i++) {
            // Find pivot
            double pivot = augmented.data[i][i];
            if (Math.abs(pivot) < 1e-10) {
                throw new IllegalArgumentException("Matrix is singular or nearly singular");
            }
            
            // Scale row
            for (int j = 0; j < 2 * n; j++) {
                augmented.data[i][j] /= pivot;
            }
            
            // Eliminate column
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmented.data[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmented.data[k][j] -= factor * augmented.data[i][j];
                    }
                }
            }
        }

        // Extract inverse
        Matrix result = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.data[i][j] = augmented.data[i][j + n];
            }
        }
        return result;
    }

    // toString method for printing matrix
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%8.2f", data[i][j]));
                if (j < cols - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Getter for testing purposes
    public double[][] getData() {
        return data;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test matrix operations
        double[][] data1 = {{1, 2}, {3, 4}};
        double[][] data2 = {{5, 6}, {7, 8}};
        Matrix m1 = new Matrix(data1);
        Matrix m2 = new Matrix(data2);

        System.out.println("Matrix 1:\n" + m1);
        System.out.println("Matrix 2:\n" + m2);
        System.out.println("Transpose of Matrix 1:\n" + m1.transpose());
        System.out.println("Addition (m1 + m2):\n" + m1.addition(m2));
        System.out.println("Subtraction (m1 - m2):\n" + m1.subtraction(m2));
        System.out.println("Multiplication (m1 * m2):\n" + m1.multiplication(m2));
        System.out.println("Inverse of Matrix 1:\n" + m1.inverse());
    }
}