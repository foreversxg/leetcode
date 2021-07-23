package com.sxg.bit;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * @author sxg
 * create in 2021/7/6
 */
public class NumberOfOneBit {

    public int hammingWeight(int n) {
        int num = 0;
        // 通过与计算来判断每一位的数字是不是1
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                num++;
            }
        }
        return num;
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
