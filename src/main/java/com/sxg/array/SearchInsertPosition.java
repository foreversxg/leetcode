package com.sxg.array;

import com.sxg.Understand;

/**
 * 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 *
 * @author foreversxg
 * create in 2021/6/23
 */
@Understand
public class SearchInsertPosition {

    public static void main(String[] args) {
        int a = searchInsert(new int[]{1, 3, 5, 6}, 2);
        int b = searchInsert(new int[]{3, 5, 6}, 1);
        System.out.println(a);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {  // todo 为什么是 <=,因为如果left right是相邻，这时应该取left+1 = (left+right)/2+1
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 用二分查找
//    public static int searchInsert(int[] nums, int target) {
//
//        int left = 0;
//        int right = nums.length - 1;
//        // 等于是为了处理target在两相邻数之间
//        // left right也可以被理解成双指针
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//
//        }
//        return left;
//    }
}