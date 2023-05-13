package com.sxg.dance;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author sxg
 * create in 2021/11/28
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "ba"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * <p>
     * 空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                // String -> length()  数组 -> array.length
                // todo  strs[j].length() == i 确保不越界再做判断
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    // substring  全部是小写
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
