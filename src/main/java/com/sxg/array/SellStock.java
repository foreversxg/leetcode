package com.sxg.array;

/**
 * @author foreversxg
 * create in 2021/7/1
 */
public class SellStock {

    public static void main(String[] args) {
        int a = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(a);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxEarn = 0;
        for (int i = 0; i < prices.length; i++) {
            maxEarn = Math.max(maxEarn, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxEarn;
    }

}
