package com.sxg.array;

import com.sxg.Understand;

/**
 * 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。《多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素！！！》
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author sxg
 * create in 2021/9/12
 */
@Understand
@Deprecated
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 2, 2, 1, 3, 5, 5}));
    }

    public int majorityElement(int[] nums) {
        int target = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                target = i;
            }
            if (target == i) {
                count++;
            } else {
                count--;
            }
        }
        return target;
    }


    /**
     * Boyer-Moore 投票算法
     *
     * 多数表示大于一半！！！！
     *
     * 数组共n个元素，假设最多元素x有m个，剩余元素k个  k=n-m
     * 我们可以得出 m > k.根据这个结论得出如下算法
     *
     * 2221355  因为没有查过大于n/2的所以数组无效
     * 前提是肯定得有一个多数
     * @param nums
     * @return
     */
//    public int majorityElement(int[] nums) {
//
//        int n = 0;
//        int count = 0;
//        for (int i : nums) {
//            if (count == 0) {
//                n = i;
//            }
//            // 即使存在21212这种情况，也会选出2
//            count += (i == n) ? 1 : -1;
//        }
//        return n;
//    }

}
