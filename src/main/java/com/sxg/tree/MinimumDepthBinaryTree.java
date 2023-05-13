package com.sxg.tree;

import com.sxg.Understand;
import com.sxg.base.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 *
 * @author sxg
 * create in 2021/7/26
 */
@Understand
public class MinimumDepthBinaryTree {


    /**
     * 深度优先算法 dfs
     *
     * @param root
     * @return
     */
    //  叶子节点是指没有子节点的节点。   这句话很重要
    public int minDepth_dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 走到这里，当前的节点就不算叶子节点，因为它有至少一个子节点
        int min = Integer.MAX_VALUE;
        // todo 这样是不是更合适？  min = Math.min(minDepth_dfs(root.left), minDepth_dfs(root.right));
        if (root.left != null) {
            min = Math.min(minDepth_dfs(root.left), min);
        }
        if (root.right != null) {
            min = Math.min(minDepth_dfs(root.right), min);
        }
        return min + 1;
    }


    public int minDepth_bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            TreeNode node = queueNode.node;
            int depth = queueNode.depth;
            if (node.right == null && node.left == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
