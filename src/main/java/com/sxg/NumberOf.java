package com.sxg;

/**
 *  二进制中1的个数
 * @author foreversxg
 * create in 2021/1/25
 */
public class NumberOf {

    public static void main(String[] args) {
        exe(3);
    }

    public static void exe(int n ) {
        if(n== 0) {
            return;
        }
        int count = 0;
        while (n > 0 || -n> 0 ) {
            if((n & 1) == 1) {
             count ++;
            }
            n =n >> 1;
        }
        System.out.println(count);
    }
}
