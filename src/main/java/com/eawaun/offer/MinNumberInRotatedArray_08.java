package com.eawaun.offer;

/**
 * 有序数组旋转后的最小值
 * 4 5 1 2 3
 */
public class MinNumberInRotatedArray_08 {
    public static int findMin(int[] a) {
        if (a == null) {
            throw new RuntimeException("invalid parameters");
        }

        int low = 0;
        int high = a.length - 1;
        int mid = low;

        while (a[low] >= a[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;

            if (a[low] == a[mid] && a[mid] == a[high]) {
                return minInOrder(a, low, high);
            }

            if (a[low] <= a[mid]) {
                low = mid;
            } else if (a[high] >= a[mid]){
                high = mid;
            }
        }

        return a[mid];
    }

    public static int minInOrder(int[] a, int low, int high) {
        int min = a[low];
        for (int i = low + 1; i <= high; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        System.out.println(findMin(a));
        int[] a2 = {1, 1, 1, 0, 1};
        System.out.println(findMin(a2));
    }
}
