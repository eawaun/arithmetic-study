package com.eawaun.offer;

import com.eawaun.offer.tree.TreeNode;

public class IsBST {

    public static boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.getValue() <= min || node.getValue() >= max) {
            return false;
        }
        return isBST(node.getLeft(), min, node.getValue()) &&
            isBST(node.getRight(), node.getValue(), max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(20);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        System.out.println(isBST(root));
    }
}
