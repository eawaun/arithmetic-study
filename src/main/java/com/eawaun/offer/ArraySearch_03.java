package com.eawaun.offer;

public class ArraySearch_03 {

    public static boolean find(int[][] array, int number) {
        boolean flag = false;
        int rows = array.length;
        if (rows < 1) {
            return flag;
        }
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (array[row][col] == number) {
                flag = true;
                break;
            } else if (array[row][col] > number) {
                col--;
            } else {
                row++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
        };
        System.out.println(find(a, 100));
    }
}
