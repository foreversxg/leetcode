package com.sxg.math;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @author sxg
 * create in 2021/8/16
 */
public class CountPrime {

    // 性能不足。执行未通过
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
