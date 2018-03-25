package com.eawaun.offer;

/**
 * 最大子字符串
 */
public class LCS {
    public static int getLCS(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        int[][] resultArr = new int[2][s2Array.length];
        int maxLength = 0, flag = 1;
        for (int i = 0; i < s2Array.length; i++) {
            resultArr[0][i] = (s1Array[0] == s2Array[i]) ? 1 : 0;
        }

        for (int i = 1; i < s1Array.length; i++) {
            for (int j = 0; j < s2Array.length; j++) {
                if (s1Array[i] == s2Array[j]) {
                    if (j == 0) {
                        resultArr[flag][j] = 1;
                    } else {
                        resultArr[flag][j] = resultArr[1 - flag][j - 1] + 1;

                        if (resultArr[flag][j] > maxLength) {
                            maxLength = resultArr[flag][j];
                        }
                    }
                } else {
                    resultArr[flag][j] = 0;
                }
            }
            flag = 1 - flag;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getLCS("ababcd", "abcd"));
    }
}
