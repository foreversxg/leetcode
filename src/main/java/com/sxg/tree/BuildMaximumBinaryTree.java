package com.sxg.tree;

import com.sxg.base.TreeNode;

/**
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * @author sxg
 * create in 2021/8/23
 */
public class BuildMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int max_i = max(nums, start, end);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = build(nums, start, max_i);
        root.right = build(nums, max_i + 1, end);
        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }


}
