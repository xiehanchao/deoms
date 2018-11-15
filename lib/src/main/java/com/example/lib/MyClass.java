package com.example.lib;


public class MyClass {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "CBAE";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        String result = null;
        //找出最小的长度
        int minLength = c1.length > c2.length ? c2.length : c1.length;
        //
        int c1_index = c1.length - 1;
        int c2_index = 0;
        if (c1[c1_index] != c2[c2_index]) {
            result = s1 + s2;
        }else {
            for (int i = 0; i < minLength; i++) {
                if (c1[c1_index] == c2[c2_index]) {
                    c1_index--;
                    c2_index++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if (result == null) {
            for (int i = 0; i <= c1_index; i++) {
                sb.append(c1[i]);
            }
            for (int j = c2_index; j <= c2.length - 1; j++) {
                sb.append(c2[j]);
            }
            System.out.println(sb.toString());
        }else {
            System.out.println(result);
        }
    }
}
