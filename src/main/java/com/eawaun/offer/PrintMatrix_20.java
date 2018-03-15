package com.eawaun.offer;

public class PrintMatrix_20 {

    public static void printMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int rows = matrix.length;
        if (rows <= 0) {
            return;
        }

        int columns = matrix[0].length;
        if (columns <= 0) {
            return;
        }

        printMatrix(matrix, rows, columns);
    }

    private static void printMatrix(int[][] matrix, int rows, int columns) {
        int start = 0;

        while (start * 2 < columns && start * 2 < rows) {
            printMatrixInCircle(matrix, rows, columns, start);
            start++;
        }
    }

    private static void printMatrixInCircle(int[][] matrix, int rows, int columns, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            System.out.print(number + " ");
        }

        //从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                int number = matrix[i][endX];
                System.out.print(number + " ");
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int number = matrix[endY][i];
                System.out.print(number + " ");
            }
        }

        if (start < endX && endY - 1 > start) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int number = matrix[i][start];
                System.out.print(number + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printMatrix(matrix);
    }
}
