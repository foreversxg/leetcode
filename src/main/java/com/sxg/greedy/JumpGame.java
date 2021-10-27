package com.sxg.greedy;

import com.sxg.Understand;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * @author sxg
 * create in 2021/8/10
 */
@Understand
public class JumpGame {

    public static void main(String[] args) {
        new JumpGame().canJump(new int[]{3, 2, 1, 0, 4});
//        new JumpGame().canJump(new int[]{3, 2, 1, 1, 4});
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            // 这个判断很重要，maxIndex要永远大于i，否则就是i这个下面无法触达
            if (i <= maxIndex) { // 防止出现0导致不能跳跃的场景  如 [3,2,1,0,4]
                maxIndex = Math.max(maxIndex, i + nums[i]);
                if (maxIndex >= n - 1) {//就是枚举每一个元素能触达的最远边界，只要最后一个下标在这个界内
                    return true;
                }
            }
        }
        return false;
    }
}
