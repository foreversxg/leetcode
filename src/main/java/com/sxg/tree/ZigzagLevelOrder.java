package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author sxg
 * create in 2021/9/5
 */
public class ZigzagLevelOrder {


    /**
     * 思路：前序遍历，在水平遍历的基础上通过linkedlist来控制节点是从头部加入还是尾部加入
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            result.add(index, new LinkedList<Integer>());
        }
        LinkedList<Integer> list = (LinkedList<Integer>) result.get(index);
        if (index % 2 == 0) {
            list.addLast(root.val);
        } else {
            list.addFirst(root.val);
        }
        processWithIndex(root.left, result, index + 1);
        processWithIndex(root.right, result, index + 1);
    }

}
