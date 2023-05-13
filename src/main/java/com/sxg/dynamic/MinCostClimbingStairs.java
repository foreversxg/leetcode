package com.sxg.dynamic;

import com.sxg.Understand;

/**
 * 746. 使用最小花费爬楼梯
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
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


    public int minCostClimbingStairs2(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i + 1], dp[i - 2] + dp[i - 2]);
        }
        return dp[cost.length];
    }


    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 你可以选择从下标为 0 或 1 的元素作为初始阶梯。 this is the point
        // 找准初始的前两个值是动态规划的关键
        // 例如 i=3时，走到第三个阶梯需要花费的体力值有两种情况
        //     1、从第1个阶梯开始，则最小体力值为 dp[0] + cost[0]
        //     2、从第2歌阶梯开始，则最小体力值为 dp[1] + cost[1]
        // 每次计算dp[i] 时，因为每次只可以爬一个阶梯或者两个阶梯，所以和dp[i-1] 和dp[i-2]有关
        dp[0] = dp[1] = 0; // 从"你可以选择从下标为 0 或 1 的元素作为初始阶梯"得出
        for (int i = 2; i <= cost.length; i++) {
            // https://leetcode-cn.com/problems/min-cost-climbing-stairs/solution/shi-yong-zui-xiao-hua-fei-pa-lou-ti-by-l-ncf8/
            // dp[i] 表示到下标为i的台阶所耗费的体力
            // dp[i - 1] + cost[i - 1]  -> 从第i-1爬到i，消耗的体力等于到i-1的总体力加上 i-1这个台阶上的体力值
            // dp[i - 2] + cost[i - 2]  -> 从第i-2爬到i，消耗的体力等于到i-2的总体力加上 i-2这个台阶上的体力值
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
//        cost.length - 1是最后一个台阶，不是顶层 ！！！！
        return dp[cost.length];
    }
}
