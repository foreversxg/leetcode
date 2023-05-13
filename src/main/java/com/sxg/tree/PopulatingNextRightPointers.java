package com.sxg.tree;

import com.sxg.base.TreeNode;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node { int val; Node *left; Node *right; Node *next; } 填充它的每个 next
 * 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 你只能使用常量级额外空间。 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * @author sxg create in 2021/8/16
 */
public class PopulatingNextRightPointers {

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        doConnect(root.left, root.right);
        return root;
    }

    private void doConnect(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        doConnect(left.left, left.right);
        doConnect(right.left, right.right);
        doConnect(left.right, right.left);

    }

}
