package com.eawaun.offer;

public class UglyNumber_34 {
    public static int getUglyNumber(int index) {
        if (index < 1) {
            return  -1;
        }

        int[] uglyNumberArray = new int[index + 1];
        uglyNumberArray[0] = 1;

        int nextUglyNumberIndex = 1;

        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;

        while (nextUglyNumberIndex <= index) {
            int min = min(uglyNumberArray[multiply2Index] * 2, uglyNumberArray[multiply3Index] * 3, uglyNumberArray[multiply5Index] * 5);
            uglyNumberArray[nextUglyNumberIndex] = min;

            while (uglyNumberArray[nextUglyNumberIndex] >= uglyNumberArray[multiply2Index] * 2)
                ++multiply2Index;
            while (uglyNumberArray[nextUglyNumberIndex] >= uglyNumberArray[multiply3Index] * 3)
                ++multiply3Index;
            while (uglyNumberArray[nextUglyNumberIndex] >= uglyNumberArray[multiply5Index] * 5)
                ++multiply5Index;

            nextUglyNumberIndex++;
        }

        return uglyNumberArray[nextUglyNumberIndex - 1];
    }

    public static int min(int a, int b, int c) {
        int tmp = a < b ? a : b;
        return tmp < c ? tmp : c;
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(10));
    }
}
