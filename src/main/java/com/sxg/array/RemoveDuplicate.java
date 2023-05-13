package com.sxg.array;

import com.sxg.Understand;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 *
 * @author foreversxg
 * create in 2021/6/22
 */
@Understand
@Deprecated
public class RemoveDuplicate {

    /**
     * 问题分解 1、有序数组找重复，重复的数肯定连续 2、去除重复后的长度，所以需要移动元素 3、去重复、移动元素 -》 快慢指针
     *
     * @param args
     */
    public static void main(String[] args) {
        int res = removeDuplicates(new int[]{1, 1, 2});
        int res1 = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        int res2 = removeDuplicates2(new int[]{1, 1, 2});
        int res3 = removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(res);
    }

    public static int removeDuplicates2(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }

        return slow + 1;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {

            if (nums[fastIndex] == nums[slowIndex]) {
                continue;
            }
            nums[++slowIndex] = nums[fastIndex];
        }
        return slowIndex + 1;
    }
}
