package com.sxg.dance;

/**
 * 674. 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * @author sxg
 * create in 2021/11/28
 */
@Deprecated
public class FindLengthOfLCIS {

    /**
     * 问题分解
     * 1、识别所有连续递增的子序列
     * 2、找出最长的子序列
     */
    public static void main(String[] args) {
        int[] nums = {4, 2, 6, 3, 5, 9, 7, 8};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS2(nums));

    }


    public static int findLengthOfLCIS2(int[] nums) {

        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }


    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {

        int max = 0;
        // 初始值必须为1 // todo   为什么！！！有一个就算1
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(count, max); // todo
                count = 1;
            }
        }
        // 最后要补一手
        return Math.max(count, max);
    }
}
