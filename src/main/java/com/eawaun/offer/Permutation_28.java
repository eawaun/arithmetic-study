package com.eawaun.offer;

public class Permutation_28 {

    public static void permutation(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        permutation(chars, 0);
    }

    public static void permutation(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            System.out.println(new String(chars) + " ");
        } else {
            char tmp;
            for (int i = begin; i < chars.length; i++) {
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                permutation(chars, begin + 1);

                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        permutation(chars);
    }
}
