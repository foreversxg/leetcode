package com.sxg.array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 *
 * @author foreversxg
 * create in 2021/6/27
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] a = new PlusOne().plusOne(new int[]{9});
        System.out.println(new PlusOne().plusOne(new int[]{1, 2, 3}));
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int up = 1;
        while (index >= 0) {
            int oldValue = digits[index];
            digits[index] = (oldValue + up) % 10;
            up = (oldValue + up) / 10;
            if (up != 1) {
                // 不需要进位可以直接返回该数组
                return digits;
            }
            index--;
        }
        // 需要进位，因为是+1，则肯定结果是一个1后面补0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
