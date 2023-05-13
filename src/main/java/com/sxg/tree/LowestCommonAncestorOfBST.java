package com.sxg.tree;

import com.sxg.Understand;
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
@Understand
@Deprecated
public class LowestCommonAncestorOfBST {


    /**
     * 前提是搜索树！！！
     * 1、取root节点到两个给定节点的链路
     * 2、逐一比对链路，最后一个相等的节点就是最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = getPath(root, p);
        List<TreeNode> listq = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < listP.size() && i < listq.size(); ++i) {
            // root到各个节点第一个不相等的时候，上一个节点就是最近公共祖先
            if (listP.get(i) == listq.get(i)) {
                ancestor = listP.get(i);
                continue;
            }
            // 必须break，否则会有问题。
            break;
        }
        return ancestor;
    }

    /**
     * 返回root节点到对应节点的链路
     *
     * @param root
     * @param target
     * @return
     */
    public List<TreeNode> getPath(TreeNode root, TreeNode target) {

        List<TreeNode> path = new ArrayList<TreeNode>();
        // 这一步很重要
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            // 大于target则取左边子树，小于则取右边子树，等于则表示就是target自身了
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
