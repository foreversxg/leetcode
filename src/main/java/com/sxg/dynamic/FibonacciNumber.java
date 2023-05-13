package com.sxg.dynamic;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * @author sxg
 * create in 2021/8/3
 */
@Deprecated
public class FibonacciNumber {


    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(10));
        System.out.println(calc2(10));
    }

    /**
     * 时间复杂度O(2^n)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 未测试
    public static int calc2(int n) {
        int f1 = 0;
        int f2 = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = f2;
            f2 = f1 + f2;
            f1 = tmp;
        }
        return f2;
    }

    /**
     * 时间复杂度O(2^n)
     * 空间复杂度O(n)
     *
     * @param n
     * @return
     */
    public static int calc(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
