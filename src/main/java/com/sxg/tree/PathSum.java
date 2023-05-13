package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 *
 * @author sxg create in 2021/7/27
 */
@Understand
public class PathSum {


    public boolean hasPathSum_dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum_dfs(root.left, targetSum - root.val) || hasPathSum_dfs(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        System.out.println(new PathSum().hasPathSum_bfs(root, 15));

    }

    public boolean hasPathSum_bfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, targetSum));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.node;
            int tempSum = queueNode.targetSum;
            if (treeNode.left == null && treeNode.right == null) {
                if (treeNode.val == tempSum) {
                    return true;
                }
                continue;
            }
            if (treeNode.left != null) {
                // 这里treeNode不要写成root
                queue.offer(new QueueNode(treeNode.left, tempSum - treeNode.val));
            }
            if (treeNode.right != null) {
                queue.offer(new QueueNode(treeNode.right, tempSum - treeNode.val));
            }

        }
        return false;
    }

    class QueueNode {
        TreeNode node;
        int targetSum;

        public QueueNode(TreeNode node, int targetSum) {
            this.node = node;
            this.targetSum = targetSum;
        }
    }

}
