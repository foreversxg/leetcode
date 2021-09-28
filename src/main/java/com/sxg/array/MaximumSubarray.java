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
public class MaximumSubarray {

    public static void main(String[] args) {
        int a = maxSubArray(new int[]{-2, -1, -3, 4, -1, 2, 1, -5, 4});
        int a1 = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int a2 = maxSubArray(new int[]{-2, 1, -3});


        int b = maxSubArray(new int[]{-5});

        System.out.println(a);
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        // 设f(i)为以i为结束点数组的连续数组最大和，那么f(i+1) = Math.max(f(i)+nums[i+1],nums[i+1]);
        int currentEndMax = 0;
        int realMax = nums[0];
        for (int n : nums) {
            // f(n)表示以n为为结束点！！！的连续数组最大和，但是起点并不一定是0
            // 例如 2-> n  亦或者是   5-> n
            // 理解这一步很关键，这一步理解了后面就水到渠成
            currentEndMax = Math.max(currentEndMax + n, n);
            // 在整个数组内，最大连续数组和->  f(1),f(2)...f(n)中的最大值
            realMax = Math.max(currentEndMax, realMax);
        }
        return realMax;
    }
}
