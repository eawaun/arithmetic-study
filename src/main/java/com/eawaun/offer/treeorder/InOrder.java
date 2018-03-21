package com.eawaun.offer.treeorder;

import com.eawaun.offer.stack.Stack;
import com.eawaun.offer.tree.TreeNode;

public class InOrder {
    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.getValue() + " ");
                p = p.getRight();
            }
        }
    }
}
