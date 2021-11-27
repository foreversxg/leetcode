package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * @author sxg
 * create in 2021/7/15
 */
@Understand
public class SymmetricTree {

    /**
     * 思路：这里的对称不能通过简单的分治处理，并不需要每个子树都是对称的，只要整树左右对称即可
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        return check(root.left, root.right);

    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        // 每一层对称的节点进行比较
        return check(left.left, right.right) && check(left.right, right.left);

    }


//    public boolean isSymmetric(TreeNode root) {
//
//        if (root.left == null && root.right == null) {
//            return true;
//        }
//        if (root.left == null || root.right == null) {
//            return false;
//        }
//        if (root.left.val != root.right.val) {
//            return false;
//        }
//        return isSymmetric(root.left) && isSymmetric(root.right);
//
//    }

}
