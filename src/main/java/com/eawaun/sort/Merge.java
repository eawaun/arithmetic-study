package com.eawaun.sort;

import static com.eawaun.sort.SortUtil.*;

/**
 * 自顶向下归并排序
 */
public class Merge {
    private static Comparable[] aux;//归并所需的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high) {
        int index1 = low, index2 = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (index1 > mid) {
                a[k] = aux[index2++];
            } else if (index2 > high) {
                a[k] = aux[index1++];
            } else if (less(aux[index1], aux[index2])) {
                a[k] = aux[index1++];
            } else {
                a[k] = aux[index2++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        assert isSort(arr);
        show(arr);
    }

}
