package com.eawaun.offer;

public class DiceProbability_43 {
    public static void printBrobability(int number) {
        if (number < 1) {
            return;
        }
        int maxValue = 6;

        int[][] probabilities = new int[2][maxValue * number + 1];
        for (int i = 0; i < maxValue * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 1;
        }

        int flag = 0;
        for (int i = 1; i <= maxValue; i++) {
            probabilities[flag][i] = 1;
        }

        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {//和等于0到k-1是不存在的
                probabilities[1 - flag][i] = 0;
            }

            for (int i = k; i <= maxValue * k; i++) {
                probabilities[1 - flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }

            flag = 1 - flag;
        }

        for (int i = number; i <= maxValue * number; i++) {
            System.out.printf("%d: %d\n", i, probabilities[flag][i]);
        }
    }

    public static void main(String[] args) {
        int number = 2;
        printBrobability(number);
    }
}
