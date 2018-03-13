package com.eawaun.sort;

public class Heap {
    public static void main(String[] args) {
        int[] arr = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        //构建最大堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    /**
     *
     * @param arr
     * @param i 第i个节点进行调整
     * @param length
     */
    public static void heapAdjust(int[] arr, int i,int length) {
        int child;
        int father = arr[i];

        //i = child表示将子节点作为子树中的父节点，继续比较找出最大的数值
        for (; 2 * i + 1 < length; i = child) {
            child = 2 * i + 1;

            if (child < length - 1 && arr[child] < arr[child + 1]) {
                child++;
            }
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }
        //将原本的值赋值给交换的节点
        arr[i] = father;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
