package com.eawaun;

public class Test {
    public static int getMaxRobMoney(int[] money, int n) {
        if (n == 1) {
            return money[n];
        }
        if (n == 2) {
            return Math.max(money[n], money[n - 1]);
        }

        return Math.max(money[n] + getMaxRobMoney(money, n - 2), getMaxRobMoney(money, n - 1));
    }

    public static void main(String[] args) {
        int[] money = {0, 11, 2, 3, 10, 3};
        System.out.println(getMaxRobMoney(money, 5));
    }
}
