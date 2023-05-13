package com.sxg.tree;

import com.sxg.base.TreeNode;

/**
 * 翻转二叉树
 *
 * @author sxg create in 2021/8/1
 */
@Deprecated
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
