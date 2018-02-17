package com.eawaun.sort;

import static com.eawaun.sort.SortUtil.isSort;
import static com.eawaun.sort.SortUtil.less;
import static com.eawaun.sort.SortUtil.show;

/**
 * 自底向上归并排序
 */
public class MergeBU {
    private static Comparable[] aux; //归并所需的辅助数组

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[a.length];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int low = 0; low < N - sz; low += 2 * sz) {
                merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
            }
        }
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
