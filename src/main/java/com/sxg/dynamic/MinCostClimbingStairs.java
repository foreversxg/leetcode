package com.sxg.dynamic;

import com.sxg.Understand;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 *
 * @author sxg
 * create in 2021/8/3
 */
@Understand
public class MinCostClimbingStairs {


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 你可以选择从下标为 0 或 1 的元素作为初始阶梯。 this is the point
        // 找准初始的前两个值是动态规划的关键
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            // https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
            // dp[i - 1] + cost[i - 1]  -> 从第i-1爬到i，消耗的体力等于到i-1的总体力加上 i-1这个台阶上的体力值
            // dp[i - 2] + cost[i - 2]  -> 从第i-2爬到i，消耗的体力等于到i-2的总体力加上 i-2这个台阶上的体力值
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
