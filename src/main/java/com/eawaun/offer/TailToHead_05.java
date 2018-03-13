package com.eawaun.offer;

import com.eawaun.offer.list.ListNode;
import com.eawaun.offer.stack.Stack;

public class TailToHead_05 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);

        head.setNext(nodeOne);
        nodeOne.setNext(nodeTwo);
        nodeTwo.setNext(nodeThree);
        nodeThree.setNext(nodeFour);

        recursion(head);
        System.out.println();
        withStack(head);
    }

    public static void recursion(ListNode head) {
        if (head != null) {
            if (head.getNext() != null) {
                recursion(head.getNext());
            }
            System.out.print(head.getValue() + " ");
        }
    }

    public static void withStack(ListNode head) {
        Stack<Integer> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p.getValue());
            p = p.getNext();
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}
