package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;

/**
 * 相同二叉树
 *
 * 对称二叉树也可以用这个方法判断
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author sxg
 * create in 2021/7/14
 */
@Understand
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
            return true;
        }
        return false;
    }
}
