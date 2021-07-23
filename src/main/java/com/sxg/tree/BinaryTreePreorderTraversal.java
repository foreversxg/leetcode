package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 *
 * @author foreversxg
 * create in 2021/7/5
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);

    }
}
