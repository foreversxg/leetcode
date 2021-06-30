package com.sxg.array;

import com.sxg.base.TreeNode;

/**
 * @author foreversxg
 * create in 2021/6/28
 */
public class SortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        return parseArrayToMap(nums, 0, nums.length - 1);

    }

    /**
     * 中序遍历
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode parseArrayToMap(int[] nums, int start, int end) {
        // 这里只用判断是否越界，否则一直递归
        if (start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode left = parseArrayToMap(nums, start, mid - 1);
        TreeNode right = parseArrayToMap(nums, mid + 1, end);
        TreeNode root = new TreeNode(nums[mid], left, right);
        return root;
    }
}
