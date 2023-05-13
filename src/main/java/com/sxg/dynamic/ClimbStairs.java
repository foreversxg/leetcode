package com.sxg.dynamic;

import com.sxg.Understand;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author sxg
 * create in 2021/11/25
 */
@Understand
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(44));
        System.out.println(new ClimbStairs().climbStairs2(10));
        System.out.println(new ClimbStairs().climbStairs3(10));

    }

    public int climbStairs3(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1; // n从1开始有意义
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // f(n) = f(n-2) + f(n-1)
        int f1 = 1;
        int f2 = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = f2;
            f2 = f1 + f2;
            f1 = temp;
        }
        return f2;

    }


    /**
     * 1	2	3	4	5  台阶数 1	2	3	5	8  方法数
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = f2; // 记住要用tmp 临时存放 f2
            f2 += f1;
            f1 = temp;
        }
        return f2;
    }
}
