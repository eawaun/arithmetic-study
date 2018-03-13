package com.eawaun.offer;

import com.eawaun.offer.tree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TopToFloorPrintTree_23 {
    public static void printFromTopToBottom(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.getValue() + "、");

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = ConstructBinaryTree_06.constructTree(preOrder, inOrder);
        printFromTopToBottom(root);
    }
}
