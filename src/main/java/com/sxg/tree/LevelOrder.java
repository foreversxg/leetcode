package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author sxg
 * create in 2021/9/5
 */
public class LevelOrder {


    /**
     * 思路：前序遍历，但是要记住当前遍历的层次用于归集到同一个数组
     *
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        processWithIndex(root, result, index);
        return result;
    }

    private void processWithIndex(TreeNode root, List<List<Integer>> result, int index) {
        if (root == null) {
            return;
        }
        if (index >= result.size()) {
            result.add(index, new ArrayList<Integer>());
        }
        List<Integer> list = result.get(index);
        list.add(root.val);
        processWithIndex(root.left, result, index + 1);
        processWithIndex(root.right, result, index + 1);
    }

}
