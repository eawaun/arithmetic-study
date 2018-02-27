package com.eawaun.dp.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * N座金矿，W个工人，金矿储量G[]，所需工人数量P[]，求能得到的最多黄金
 * 思路参考自：
 * https://zhuanlan.zhihu.com/p/31628866
 * http://www.cnblogs.com/hczd123/p/7412950.html
 */
public class GoldMiner {
    /**
     * 递归解法
     * @param n 金矿数
     * @param w 工人数
     * @param G 金矿含量数组
     * @param P 所需工人数量数组
     * @return
     */
    public static int recursion(int n, int w, int[] G, int[] P) {
        if (n <= 1 && w < P[0]) {
            return 0;
        }

        if (n == 1 && w >= P[0]) {
            return G[0];
        }

        if (n > 1 && w < P[n - 1]) {
            return  recursion(n - 1, w, G, P);
        }

        if (n > 1 && w >= P[n - 1]) {
            return Math.max(recursion(n - 1, w, G, P),
                recursion(n - 1, w - P[n - 1], G, P) + G[n - 1]);
        }

        throw new RuntimeException("cannot reach here");// cannot reach here
    }

    static class MemoKey {
        private int n;
        private int w;

        public MemoKey(int n, int w) {
            this.n = n;
            this.w = w;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            MemoKey key;
            if (obj instanceof MemoKey) {
                key = (MemoKey) obj;
                if (key.getN() == this.n && key.getW() == this.w) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 备忘录解法
     * @param n 金矿数
     * @param w 工人数
     * @param memoMap 保存已计算过的结果
     * @param G 金矿含量数组
     * @param P 所需工人数量数组
     * @return
     */
    public static int memo(int n, int w, Map<MemoKey, Integer> memoMap,int[] G, int[] P) {
        if (n <= 1 && w < P[0]) {
            return 0;
        }

        if (n == 1 && w >= P[0]) {
            return G[0];
        }

        if (n > 1 && w < P[n - 1]) {
            MemoKey key = new MemoKey(n-1, w);
            if (memoMap.containsKey(key)) {
                return memoMap.get(key);
            } else {
                int value = recursion(n - 1, w, G, P);
                memoMap.put(key, value);
                return value;
            }
        }

        if (n > 1 && w >= P[n - 1]) {
            MemoKey key1 = new MemoKey(n - 1, w);
            MemoKey key2 = new MemoKey(n - 1, w - P[n - 1]);
            int value1, value2;

            if (memoMap.containsKey(key1)) {
                value1 = memoMap.get(key1);
            } else {
                value1 = memo(n - 1, w, memoMap, G, P);
                memoMap.put(key1, value1);
            }

            if (memoMap.containsKey(key2)) {
                value2 = memoMap.get(key2);
            } else {
                value2 = memo(n - 1, w - P[n - 1], memoMap, G, P);
                memoMap.put(key2, value2);
            }
            value2 += G[n - 1];

            return Math.max(value1, value2);
        }

        throw new RuntimeException("cannot reach here");// cannot reach here
    }

    /**
     * 动态规划解法
     *
     * 时间复杂度O(n * w) 空间复杂度O(w)
     * @param n 金矿数
     * @param w 工人数
     * @param G 金矿含量数组
     * @param P 所需工人数量数组
     * @return
     */
    public static int dp(int n, int w, int[] G, int[] P) {
        int colLength = w + 1; //要用到第0列，因此一共有w+1列

        int[] prevResults = new int[colLength];
        int[] results = new int[colLength];

        //初始化第一行（边界）
        for (int i = 0; i < colLength; i++) {
            if (i < P[0]) {
                prevResults[i] = 0;
            } else {
                prevResults[i] = G[0];
            }
        }

        //用上一行推出下一行
        for (int i = 0; i < n; i++) {//0表示前1个金矿
            for (int j = 0; j < colLength; j++) {//0表示0个矿工
                if (j < P[i]) {
                    results[j] = prevResults[j];
                } else {
                    results[j] = Math.max(prevResults[j], prevResults[j - P[i]] + G[i]);
                }
            }

            for (int z = 0; z < results.length; z++) {
                prevResults[z] = results[z];
            }
        }
        return results[w];
    }

    public static void main(String[] args) {
        int N = 5, W = 10;
        int[] G = {500, 200, 300, 350, 400};
        int[] P = {5, 3, 4, 2, 5};
        System.out.println(recursion(N, W, G, P));
        System.out.println(memo(N, W, new HashMap<>(), G, P));
        System.out.println(dp(N, W, G, P));
    }
}
