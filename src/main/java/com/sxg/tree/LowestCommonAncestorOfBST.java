package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）
 *
 * @author sxg
 * create in 2021/8/1
 */
public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = getPath(root, p);
        List<TreeNode> listq = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < listP.size() && i < listq.size(); ++i) {
            if (listP.get(i) == listq.get(i)) {
                ancestor = listP.get(i);
                continue;
            }
            // 必须break，否则会有问题。
            break;
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {

        List<TreeNode> path = new ArrayList<TreeNode>();
        // 这一步很重要
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }
}
