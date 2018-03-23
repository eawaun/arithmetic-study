package com.eawaun.offer;

/**
 * 给定一个整数n，给定一个整数m，将1~n个整数按字典顺序进行排序，返回排序后第m个元素。n最大可为5000000。
 * 字典排序的含义为：从最高位开始比较。
 * 1开头的数字排在最前面，然后是2开头的数字，然后是3开头的数字……最高位相同的数字，按同样的逻辑比较次高位……以此类推。
 * 例：给定整数为n=13,m=5，那么字典排序结果为： [1,10,11,12,13,2,3,4,5,6,7,8,9] ，程序最终输出为13。
 */
public class MthInDictionarySort {
    //返回以数字k开头，<=n的数的个数
    public static int getNum(int n, int k) {
        int base = 1, sum = 0;
        while (n >= base * (k+1) -1) {
            sum += base;
            base *= 10;
        }
        if (n >= base * k) //如n = 198 k = 1 时，会进入这个条件
            sum += n - base * k + 1;
        return sum;
    }

    public static int getMth(int n, int m, int cur) {
        return -1;
    }

    public static void main(String[] args) {
        int n = 201;
        int m = 200;
        int i; //从哪个数开头来开始找
        for (i = 1; i <= 9; i++) {
            int num = getNum(n, i);
            if (num < m) {
                m -= num; //m大于i开头的数字的数量，减掉这个数量，得到的数字再作为下一轮是否大于i+1开头数字的判断
            } else {
                break;
            }
        }



    }
}
