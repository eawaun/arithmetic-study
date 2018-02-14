package com.eawaun.sort;

import static com.eawaun.sort.SortUtil.*;

/**
 * 希尔排序
 *
 * 任意间隔为h的数组都是有序的，称为h有序数组
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; //1, 4, 13, 40, 121, 364, 1093, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        assert isSort(arr);
        show(arr);
    }
}
