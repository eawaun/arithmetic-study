package com.eawaun.offer;

import com.eawaun.offer.tree.TreeNode;

public class SubstructureInTree_18 {

    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.getValue() == root2.getValue()) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.getLeft(), root2);
            }
            if (!result) {
                result = hasSubtree(root1.getRight(), root2);
            }
        }

        return result;
    }

    private static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null) {
            return false;
        }

        if (root1.getValue() != root2.getValue()) {
            return false;
        }

        return doesTree1HaveTree2(root1.getLeft(), root2.getLeft()) &&
            doesTree1HaveTree2(root1.getRight(), root2.getRight());
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        /**
         *   8
         *  / \
         *  8  7
         *  /\
         *  9 2
         *    /\
         *   4  7
         */
        root1.setLeft(node2);
        root1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node6);
        node5.setRight(node7);

        /**
         *    8
         *   /\
         *  9 2
         */
        TreeNode root2 = new TreeNode(8);
        TreeNode node22 = new TreeNode(9);
        TreeNode node23 = new TreeNode(2);
        root2.setLeft(node22);
        root2.setRight(node23);

        System.out.println(hasSubtree(root1, root2));
    }
}
