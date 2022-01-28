package com.sxg.dance;

/**
 * 415. 字符串相加
 *
 * @author sxg
 * create in 2021/12/1
 */
public class TwoString {

    public static void main(String[] args) {
        int a = '8';
        int b = '8' - '0';
        System.out.println(a + b);
    }

    public String addStrings(String num1, String num2) {
        int a = num1.length() - 1;
        int b = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (a >= 0 || b >= 0 || add > 0) {
            int x = a >= 0 ? num1.charAt(a) - '0' : 0;
            int y = b >= 0 ? num1.charAt(b) - '0' : 0;
            int result = x + y + add;
            add = result / 10;
            sb.append(result % 10);
            a--;
            b--;
        }
        sb.reverse();
        return sb.toString();
    }
}
