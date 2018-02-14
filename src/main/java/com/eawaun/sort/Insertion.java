package com.eawaun.sort;

import static com.eawaun.sort.SortUtil.*;

/**
 * 插入排序
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
//        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(arr);
        assert isSort(arr);
        show(arr);
    }
}
