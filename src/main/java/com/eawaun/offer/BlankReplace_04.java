package com.eawaun.offer;

public class BlankReplace_04 {
    public static void replaceBlank(char[] array, int originalLength) {
        if (array == null || originalLength <= 0) {
            return;
        }
        //计算空格数
        int blank = 0;
        for (int i = 0; i < originalLength; i++) {
            if (array[i] == ' ') {
                blank++;
            }
        }

        int oldLength = originalLength;
        int newLength = originalLength + blank * 2;
        if (newLength > array.length) {
            return;
        }

        if (newLength > oldLength) {
            int indexOfOld = oldLength - 1;
            int indexOfNew = newLength -1;

            while (indexOfOld > 0 && indexOfNew > 0) {
                if (array[indexOfOld] == ' ') {
                    array[indexOfNew--] = '0';
                    array[indexOfNew--] = '2';
                    array[indexOfNew--] = '%';
                } else {
                    array[indexOfNew--] = array[indexOfOld];
                }
                indexOfOld--;
            }
        }


        System.out.println(new String(array, 0, newLength));
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        char[] cOld = s.toCharArray();
        char[] cNew = new char[100];
        for (int i = 0; i < cOld.length; i++) {
            cNew[i] = cOld[i];
        }
        replaceBlank(cNew, cOld.length);
    }
}
