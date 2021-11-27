package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author sxg
 * create in 2021/8/17
 */
@Understand
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        // 先完成各子树的展开，然后再用root关联
        //    左子树链表  -> root.val -> 右子树链表
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left; //因为是前序遍历 把左节点直接放在 链表下个节点
        root.left = null;
        TreeNode pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }
        pointer.right = right; // 右节点要连接到到左子树生成的链表尾部
    }

}
