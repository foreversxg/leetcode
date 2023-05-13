package com.sxg.array;

import com.sxg.Understand;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 输出：[1,2,2,3,5,6] 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0 输出：[1]
 *
 * @author foreversxg create in 2021/6/28
 */
@Deprecated
@Understand
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(num1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1; // todo 这里不能用m因为m!=num1.legnth  m=有效元素长度
        while (m > 0 || n > 0) {
            if (m == 0) {
                nums1[index] = nums2[n - 1];
                n--;
            } else if (n == 0) {
                nums1[index] = nums1[m - 1];
                m--;
            } else if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        // 策略，逆向双指针,利用有序的特性，将最大值搬运到数组的最后 ！！！
//        // 从最后一位开始逆排序，这样可以简化从头排序的复杂度，正好条件中对num1的长度说明也印证了可行性。
//        int index = nums1.length - 1;
//        while (m > 0 || n > 0) {
//            // 先考虑m==0 或者 n==0的临界条件
//            if (m == 0) {
//                nums1[index] = nums2[n - 1];
//                n--;
//            } else if (n == 0) {
//                nums1[index] = nums1[m - 1];
//                m--;
//            } else if (nums1[m - 1] >= nums2[n - 1]) {
//                nums1[index] = nums1[m - 1];
//                m--;
//            } else {
//                nums1[index] = nums2[n - 1];
//                n--;
//            }
//            index--;
//        }
//    }
}
