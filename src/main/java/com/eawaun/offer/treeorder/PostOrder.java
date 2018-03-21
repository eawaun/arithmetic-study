package com.eawaun.offer.treeorder;

import com.eawaun.offer.stack.Stack;
import com.eawaun.offer.tree.TreeNode;

/**
 * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；
 * 或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
 * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，
 * 这样就保证了每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
 */
public class PostOrder {
    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.getLeft() == null && cur.getRight() == null) ||
                (pre != null && (pre == cur.getLeft() || pre == cur.getRight()))) {
                System.out.print(cur.getValue() + " ");
                stack.pop();
                pre = cur;
            } else {
                if (cur.getRight() != null) {
                    stack.push(cur.getRight());
                }
                if (cur.getLeft() != null) {
                    stack.push(cur.getLeft());
                }
            }
        }
    }
}
