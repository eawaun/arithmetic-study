package com.eawaun.exam;

import java.util.*;

/**
 * https://www.nowcoder.com/test/8537209/summary
 *
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 */
public class Bracelet {
    /**
     *
     * @param color
     * @param key 珠编号
     * @param colorMap
     * @return
     */
    private static int findKey(int color, int key, Map<Integer, List<Integer>> colorMap) {
        return colorMap.get(color).stream().anyMatch(num -> num == key) ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//n个串珠
        int m = input.nextInt();//约束条件：m个连续串珠
        int c = input.nextInt();//出现的颜色数


        Map<Integer/* 颜色 */, List<Integer> /* 所在珠的编号list */ > colorMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int num = input.nextInt();//当前珠子出现的颜色个数
            while (num-- > 0) {
                int color = input.nextInt();
                List<Integer> list = colorMap.get(color);//color所在的珠的编号
                if (list == null) {
                    list = new ArrayList<>();
                    colorMap.put(color, list);
                }
                list.add(i);
            }
        }

        for (int i = 1; i <= c; i++) {
            if (colorMap.get(i) == null || colorMap.get(i).isEmpty()) {
                continue;
            }

            List<Integer> temp = new ArrayList<>();
            colorMap.get(i).forEach(temp::add);

            for (int j = 0; j < temp.size(); j++) {
                colorMap.get(i).add(temp.get(j) + n);
            }
        }

        int ans = 0;
        for (int i = 1; i <= c; i++) {
            if (colorMap.get(i) == null || colorMap.get(i).isEmpty()) {
                continue;
            }

            int low = 1, high = 1, sum = findKey(i, 1, colorMap);

            for (; low + m <= n * 2; low++) {
                while (high - low + 1 < m) {
                    ++high;
                    sum += findKey(i, high, colorMap);
                }

                if (sum > 1) {
                    ans++;
                    break;
                }

                sum -= findKey(i, low, colorMap);
            }
        }

        System.out.println(ans);
    }
}
