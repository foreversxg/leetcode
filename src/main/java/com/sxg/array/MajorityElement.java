package com.sxg.array;

/**
 * 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author sxg
 * create in 2021/9/12
 */
public class MajorityElement {

    /**
     * Boyer-Moore 投票算法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int n = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                n = i;
            }
            // 即使存在21212这种情况，也会选出2
            count += (i == n) ? 1 : -1;
        }
        return n;
    }

}
