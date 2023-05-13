package com.sxg.array;

import com.sxg.Understand;

/**
 * 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 *
 * @author foreversxg
 * create in 2021/6/24
 */
@Understand
@Deprecated
public class MaximumSubarray {

    /**
     * 问题分解
     * 1、到每个位置为结束点的最大值 （分）
     * 2、所有位置计算的最大值取 最大值 （合）
     *
     * @param args
     */
    public static void main(String[] args) {
//        int a = maxSubArray(new int[]{-2, -1, -3, 4, -1, 2, 1, -5, 4});
//        int a1 = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int a2 = maxSubArray(new int[]{1, 2, -1, 1});


        int b = maxSubArray(new int[]{-5});

//        System.out.println(a);
    }

    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int totalMax = 0;
        for (int i = 1; i < nums.length; i++) {
            // 只要currentMax是正数，则以i为结束点的最大连续数组和max(i) = currentMax+num[i]成立！！！
            // 如果currentMax变成负值，则会重新计算连续数组的起始位  ！！！！
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            totalMax = Math.max(currentMax, totalMax);
        }
        return totalMax;
    }


    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        // 设f(i)为以i为结束点数组的连续数组最大和，那么f(i+1) = Math.max(f(i)+nums[i+1],nums[i+1]);
//        int currentEndMax = 0;
//        int realMax = nums[0];
//        for (int n : nums) {
//            // f(n)表示以n为为结束点！！！的连续数组最大和，但是起点并不一定是0
//            // 例如 2-> n  亦或者是   5-> n
//            // f(i+1) 表示以i+1为结束点的最大和，那么既然连续则可以继承f(i),但是如果此时f(n)是负数或0，则不对于总和提高无效，于是此时直接取num[i+1]作为f(i+1)的值
//            // 理解这一步很关键，这一步理解了后面就水到渠成
//            currentEndMax = Math.max(currentEndMax + n, n);
//            // 在整个数组内，最大连续数组和->  f(1),f(2)...f(n)中的最大值
//            realMax = Math.max(currentEndMax, realMax);
//        }
//        return realMax;
//    }
}
