package com.eawaun.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/8537209/summary
 */
public class UserLike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (hm.containsKey(temp)) {
                hm.get(temp).add(i);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                hm.put(temp, al);
            }

        }

        int m = sc.nextInt();
        int b[] = new int[m];

        for (int j = 0; j < m; j++) {
            int low = sc.nextInt() - 1;
            int high = sc.nextInt() - 1;
            int key = sc.nextInt();
            if (!hm.containsKey(key)) {
                b[j] = 0;
            } else {
                b[j] = getNum(low, high, hm.get(key));
            }

        }
        for (int j = 0; j < m; j++) {
            System.out.println(b[j]);
        }
        sc.close();
    }

    public static int getNum(int low, int high, ArrayList<Integer> al) {
        int i = 0;
        int j = al.size() - 1;
        if (al.get(i) > high || al.get(j) < low) {
            return 0;
        } else {
            while (al.get(i) < low || al.get(j) > high) {
                if (al.get(i) < low) i++;
                if (al.get(j) > high) j--;
            }
            return j - i + 1;
        }
    }
}
