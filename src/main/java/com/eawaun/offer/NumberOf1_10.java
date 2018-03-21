package com.eawaun.offer;

/**
 * 数n二进制中1的数量
 */
public class NumberOf1_10 {
    public static int numberOf1(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(-1));
    }
}
