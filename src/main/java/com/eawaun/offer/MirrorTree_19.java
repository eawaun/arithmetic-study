package com.eawaun.offer;

import com.eawaun.offer.tree.TreeNode;

public class MirrorTree_19 {

    public static void mirrorRecursively(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return;
        }

        TreeNode tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);

        if (root.getLeft() != null) {
            mirrorRecursively(root.getLeft());
        }

        if (root.getRight() != null) {
            mirrorRecursively(root.getRight());
        }
    }

    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.getValue() + " ");
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        printPreOrder(root);
        System.out.println();
        mirrorRecursively(root);
        printPreOrder(root);
    }
}
