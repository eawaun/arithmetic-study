package com.eawaun.offer;

public class SequenceOfBST_24 {
    public static boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    public static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start < 0 || end >= sequence.length) {
            throw new RuntimeException("invalid parameter");
        }

        int root = sequence[end];
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }

        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if (i > start) {
            left = verifySequenceOfBST(sequence, start, i - 1);
        }
        boolean right = true;
        if (i < end) {
            right = verifySequenceOfBST(sequence, i, end - 1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifySequenceOfBST(sequence));
        int[] sequence2 = {9, 6, 5, 7, 11, 10, 8};
        System.out.println(verifySequenceOfBST(sequence2));
    }
}
