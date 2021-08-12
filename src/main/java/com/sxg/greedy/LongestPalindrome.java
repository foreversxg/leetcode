package com.sxg.greedy;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * @author sxg
 * create in 2021/8/9
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        int[] array = new int[128]; // 大小写字母 128以内
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            array[c]++;
        }
        int res = 0;
        for (int count : array) {
            res += count / 2 * 2; // 这里如果count=1就会不计入res
            if (count % 2 == 1 && res % 2 == 0) {
                res++;// 单个字符出现一次的场景
            }
        }
        return res;
    }
}
