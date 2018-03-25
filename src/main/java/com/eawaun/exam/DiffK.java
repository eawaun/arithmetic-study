package com.eawaun.exam;

import java.util.*;

/**
 * 在n个元素的数组中，找到差值为k的数字对去重后的个数
 * https://blog.csdn.net/u014627239/article/details/79683481
 */
public class DiffK {
    static int h(int[] nums, int dif) {
        BitSet b = new BitSet();

        for (int i : nums) {
            b.set(i);
        }
        Arrays.sort(nums);
        int cnt = 0;
        int last = nums[0];

        for (int i : nums) {
            if (i != last && b.get(i + dif)) {
                cnt++;
            }
            last = i;
        }

        if (b.get(nums[0] + dif)) cnt++;

        return cnt;
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int size = sc.nextInt();
            int dif = sc.nextInt();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = sc.nextInt();
            }

            int res = h(nums, dif);
            System.out.println(res);
        }
        sc.close();
    }
}
