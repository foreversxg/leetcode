package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * @author sxg
 * create in 2021/8/31
 */
public class NumTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }
        return createTree(1, n);
    }

    private List<TreeNode> createTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            // 这一步不能少，否则在最后一层处理的时候返回空集合直接跳过了节点赋值！！！
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            // 这里是一个后序遍历的逻辑，通过先得出左右两颗子树的节点，然后和当前节点拼接成一颗新的子树
            List<TreeNode> leftTree = createTree(start, i - 1);
            List<TreeNode> rightTree = createTree(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    result.add(currentRoot);
                }
            }
        }
        return result;
    }
}
