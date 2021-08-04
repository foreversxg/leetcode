package com.sxg.greedy;

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * @author foreversxg
 * create in 2021/7/1
 */
public class SellStock2 {

    public static void main(String[] args) {
        int a = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }

    /**
     * 贪心算法
     * 把求解的问题分成若干个子问题
     * 对每个子问题求解，得到子问题的局部最优解
     * 把子问题的解局部最优解合成原来问题的一个解
     *
     * 这里是把所有的正差价都计算进去
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxEarn = 0;
        for (int i = 1; i < prices.length; i++) {
            int res = prices[i] - prices[i - 1];
            if (res > 0) {
                maxEarn = maxEarn + res;
            }
        }
        return maxEarn;
    }

}
