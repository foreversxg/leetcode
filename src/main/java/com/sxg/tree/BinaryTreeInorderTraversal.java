package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 *
 * @author foreversxg
 * create in 2021/7/5
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
}
