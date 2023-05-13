package com.sxg.dance;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author sxg
 * create in 2021/11/26
 */
@Deprecated
public class LengthOfLongestSubstring {


    /**
     * 需要解决的问题
     * 1.识别重复
     * 2.重复字符的位置，是否需要重置start位置
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置 char一共能表示128个正值
        // 这里不能用map，因为发现重复需要移除的不单单是重复的字符，而是重复的字段前面的都要移除
        int[] last = new int[128]; // todo 128
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int max = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            char index = s.charAt(i); // i位置对应的char
            // last[index]表示字符上一次出现的位置，如果比start小则表示从start开始的位置没有重复
            // 如果比start大则表示有重复，这一次计算的无重复长度到此位置，下个start=last[index] + 1  从上一个重复位置+1再次开始
            start = Math.max(start, last[index] + 1); // todo 这里理解很重要
            max = Math.max(max, i - start + 1);
            last[index] = i;
        }

        return max;
    }

}
