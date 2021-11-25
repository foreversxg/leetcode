package com.sxg.tree;

import com.sxg.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 *
 * @author sxg
 * create in 2021/9/5
 */
public class PreMidBuildTree {

    private int[] preorder;
    private int[] inorder;
    private int index;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 前序+中序   时，index要从0开始，很为前序根节点在开头
        index = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reBuild(0, inorder.length - 1);
    }

    private TreeNode reBuild(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int inRootIndex = map.get(preorder[index]);
        index++;
        // 先左后右！！！为了配合index移动
        root.left = reBuild(left, inRootIndex - 1);
        root.right = reBuild(inRootIndex + 1, right);
        return root;
    }
}
