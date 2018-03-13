package com.eawaun.sort;

import util.StdRandom;

import static com.eawaun.sort.SortUtil.*;

public class Quick {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partitionV2(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        //将数组切分为a[low ... i-1], a[i], a[i+1, high]
        int i = low, j = high + 1;
        Comparable v = a[low]; //切分元素
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == high) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    private static int partitionV2(Comparable[] a, int low, int high) {
        Comparable pivot = a[low];
        while (low < high) {
            while (low < high && less(pivot, a[high])) --high;
            a[low] = a[high];
            while (low < high && less(a[low], pivot)) ++low;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        assert isSort(arr);
        show(arr);
    }
}
