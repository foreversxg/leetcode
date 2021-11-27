package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author sxg
 * create in 2021/9/5
 */
@Understand
public class MidPostBuildTree {

    private int[] inorder;
    private int[] postorder;
    private int index;
    private Map<Integer, Integer> map = new HashMap<>();

    /**
     * 解题思路：核心还是中序可以用根节点将数组切分成左右子树，然后再每个子树数组里在找到根节点。
     * 后序遍历在这里很明显是启辅助作用，提供每一个子树的根节点！！！其倒序的顺序刚好是从右到左根节点的排序。
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inorder = inorder;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = inorder.length - 1;
        return rebuild(0, index);
    }

    private TreeNode rebuild(int left, int right) {

        // 递归结束条件
        if (left > right) {
            return null;
        }
        // 后续遍历的最后一个节点就是根节点
        TreeNode root = new TreeNode(postorder[index]);
        // 找到根节点在中序遍历数组中的位置，然后根据这个位置将中序遍历数组切分为左右子树
        int midIndex = map.get(postorder[index]);
        index--;
        // 先处理右子树，因为后序遍历是先左后右，所以在倒序寻找根节点的时候一定是先到右子树的根节点
        // 先从右边主要是考虑用index--在后续遍历中寻找子树的根节点
        root.right = rebuild(midIndex + 1, right);
        root.left = rebuild(left, midIndex - 1);
        return root;
    }

}
