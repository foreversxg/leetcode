package com.sxg.number;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @author sxg
 * create in 2022/1/30
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(123221));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        // x为奇数时 reverse需要/10
        return x == reverse || x == reverse / 10;
    }
}
