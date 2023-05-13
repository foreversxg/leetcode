package com.sxg.dynamic;

import com.sxg.Understand;

/**
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
 *
 *
 * @author foreversxg
 * create in 2021/7/1
 */
@Understand
public class SellStock {

    /**
     * 问题分解
     * <p>
     * 1、最大利润 = 最高价 - 最低价 （如果单纯的用最大值减去最小值，可能会出现最大值在最小值之前的问题，所以只能逐步以当前结束点为最大值，寻找前面的最小值进行计算，最后统计出最大利润）
     * <p>
     * 2、计算每个点为结束点内的最大利润
     * <p>
     * 3、计算之前所有的最大利润中的最大值
     *
     * @param args
     */
    public static void main(String[] args) {
        int a = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxEarn = 0;
        for (int i = 0; i < prices.length; i++) {
            maxEarn = Math.max(maxEarn, prices[i] - minPrice);
            // 寻找最小值，并更新之
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxEarn;
    }

}
