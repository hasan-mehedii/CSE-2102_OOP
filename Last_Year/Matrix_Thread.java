import java.util.Scanner;

class MatrixInput {
    public static void enterMatrixData(Scanner scanner, int[][] matrix, String matrixName) {
        System.out.println("Enter elements of " + matrixName + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}

class MatrixMultiplicationThread extends Thread {
    private int[][] A, B, C;
    private int row;
    
    public MatrixMultiplicationThread(int[][] A, int[][] B, int[][] C, int row) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
    }
    
    @Override
    public void run() {
        int colsB = B[0].length;
        int colsA = A[0].length;
        for (int j = 0; j < colsB; j++) {
            C[row][j] = 0;
            for (int k = 0; k < colsA; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class Matrix_Thread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows for Matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter number of columns for Matrix A: ");
        int colsA = scanner.nextInt();
        
        System.out.print("Enter number of rows for Matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter number of columns for Matrix B: ");
        int colsB = scanner.nextInt();
        
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible. Columns of A must match rows of B.");
            return;
        }
        
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        int[][] C = new int[rowsA][colsB];
        
        MatrixInput.enterMatrixData(scanner, A, "Matrix A");
        MatrixInput.enterMatrixData(scanner, B, "Matrix B");
        
        Thread[] threads = new Thread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new MatrixMultiplicationThread(A, B, C, i);
            threads[i].start();
        }
        
        for (int i = 0; i < rowsA; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Resultant Matrix C:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
