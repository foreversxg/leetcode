package com.sxg.bit;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author foreversxg
 * create in 2021/7/2
 */
public class SingleNumber {

    public static void main(String[] args) {
        int a = new SingleNumber().singleNumber(new int[]{2, 3, 4, 3, 2});
        System.out.println(a);
    }

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // 利用异或来处理
            result = result ^ nums[i];
        }
        return result;
    }
}
