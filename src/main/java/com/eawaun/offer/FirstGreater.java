package com.eawaun.offer;

import com.eawaun.offer.stack.Stack;

import java.util.HashMap;
import java.util.Map;

/**
 * 求一个数组中右边第一个比他大的数
 */
public class FirstGreater {
    public static Map<Integer, Integer> findFirstGreater(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }

        Map<Integer, Integer> result = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                result.put(stack.pop(), arr[i]);
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 0, 5};
        Map<Integer, Integer> result = findFirstGreater(arr);
        result.forEach((k, v) -> {
            System.out.println(k + " => " + v);
        });
    }
}
