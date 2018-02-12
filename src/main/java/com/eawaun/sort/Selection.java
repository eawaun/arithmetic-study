package com.eawaun.sort;

import static com.eawaun.sort.SortUtil.*;

/**
 * 选择排序
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 1, 4, 3, 7, 8, 6, 5, 9};
        sort(arr);
        assert isSort(arr);
        show(arr);
    }
}
