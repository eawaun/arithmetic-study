package com.eawaun.offer;

import com.eawaun.offer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中从根节点开始的路径中 和为n的路径
 */
public class PathInTree_25 {

    public static void findPath(TreeNode root, int sum) {
        if (root == null || sum <= 0) {
            return;
        }

        dfs(root, sum, new ArrayList<>(), 0);
    }

    private static void dfs(TreeNode node, int sum, List<Integer> path, int currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.getValue();
        path.add(node.getValue());
        if (currentSum == sum) {
            path.forEach(item -> System.out.print(item + " "));
            System.out.println();
        } else {
            dfs(node.getLeft(), sum, path, currentSum);
            dfs(node.getRight(), sum, path, currentSum);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        findPath(root, 22);
    }
}
