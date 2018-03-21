package com.eawaun.offer;

import com.eawaun.offer.stack.Stack;

/**
 * 给定两个数组
 * 第一个数组表示入栈顺序
 * 判断第二个数组是否是第一个数组的出栈顺序
 */
public class StackPushPopOrder_22 {
    public static boolean isPopOrder(int[] pushArray, int[] popArray) {
        if (pushArray == null || popArray == null) {
            return false;
        }

        if (pushArray.length != popArray.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushArrayIndex = 0;
        int popArrayIndex = 0;

        while (pushArrayIndex < pushArray.length) {
            if (!stack.isEmpty() && stack.peek() == popArray[popArrayIndex]) {
                stack.pop();
                popArrayIndex++;
            } else {
                stack.push(pushArray[pushArrayIndex++]);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == popArray[popArrayIndex]) {
                stack.pop();
                popArrayIndex++;
            } else {
                break;
            }
        }

        return stack.isEmpty() && popArrayIndex == popArray.length;
    }

    public static void main(String[] args) {
        // 测试用例
        // 第一组
        int[] pushArray1 = {1, 2, 3, 4, 5};
        int[] popArray1 = {4, 5, 3, 2, 1};
        System.out.println("第一组：" + isPopOrder(pushArray1, popArray1));

        // 第二组
        int[] pushArray2 = {1, 2, 3, 4, 5};
        int[] popArray2 = {4, 3, 5, 1, 2};
        System.out.println("第二组：" + isPopOrder(pushArray2, popArray2));

        // 第三组，长度不等
        int[] pushArray3 = {1, 2, 3, 4, 5};
        int[] popArray3 = {4, 5, 3};
        System.out.println("第三组：" + isPopOrder(pushArray3, popArray3));
    }
}
