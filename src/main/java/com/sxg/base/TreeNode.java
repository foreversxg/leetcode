package com.sxg.base;

/**
 * @author foreversxg
 * create in 2021/6/28
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
