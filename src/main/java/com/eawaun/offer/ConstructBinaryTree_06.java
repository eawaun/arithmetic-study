package com.eawaun.offer;

import com.eawaun.offer.tree.BinaryTreeNode;

public class ConstructBinaryTree_06 {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = constructTree(preOrder, inOrder);
        printPostOrder(root);
    }

    public static BinaryTreeNode constructTree(int[] preOrder, int[] inOrder) {
        return constructTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode constructTree(int[] preOrder, int[] inOrder, int preStart, int preEnd,
                                               int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(preOrder[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == preOrder[preStart]) {
                root.setLeft(constructTree(preOrder, inOrder, preStart + 1, preStart + i - inStart,
                    inStart, i - 1));
                root.setRight(constructTree(preOrder, inOrder, preStart + i - inStart + 1, preEnd, i + 1, inEnd));
            }
        }
        return root;

    }

    public static void printPostOrder(BinaryTreeNode root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.print(root.getValue() + "、");
        }
    }
}
