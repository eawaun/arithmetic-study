package com.eawaun.offer;

/**
 * 旋转数组的查找
 * 4 5 1 2 3
 */
public class RotatedSortedArraySearch {
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (arr[left] > arr[mid]) {
                if (target > arr[mid] && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < arr[mid] && target > arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        System.out.println(search(arr, 4));
    }
}
