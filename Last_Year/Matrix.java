// 3. Consider that you are given two matrices A and B. You need to find the matrix C, such 
//    that C is the multiplicative result of A and B. Thus, C=AxB.

// (a) Write a Java program to find C. Note that you need to write the program to take input as well as
//   to calculate and print the final result.

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

class MatrixMultiplication {
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] C = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}

public class Matrix {
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
            System.out.println("Matrix multiplication is not possible.");
            return;
        }
        
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        
        MatrixInput.enterMatrixData(scanner, A, "Matrix A");
        MatrixInput.enterMatrixData(scanner, B, "Matrix B");
        
        int[][] C = MatrixMultiplication.multiplyMatrices(A, B);
        
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
