package com.eawaun.offer.treeorder;

import com.eawaun.offer.stack.Stack;
import com.eawaun.offer.tree.TreeNode;

public class PreOrder {
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.getValue() + " ");
                stack.push(p);
                p = p.getLeft();
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.getRight();
            }
        }
    }
}
