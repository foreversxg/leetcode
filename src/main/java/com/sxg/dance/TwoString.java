package com.sxg.dance;

import com.sxg.Understand;

/**
 * 415. 字符串相加
 *
 * @author sxg create in 2021/12/1
 */
@Understand
@Deprecated
public class TwoString {

    /**
     * 问题分解
     * <p>1、每一个对等位相加 （位置同步移动）
     * <p>2、考虑进位
     * 注意 ： 字符转int需要 char-'0'
     *
     * @param args
     */
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
