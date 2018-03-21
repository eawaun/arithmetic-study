package com.eawaun.offer;

import com.eawaun.offer.list.ListNode;
import com.eawaun.offer.stack.Stack;

/**
 * 从尾到头打印链表
 */
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
        System.out.println();
        changeStruct(head);
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
    }

    public static void changeStruct(ListNode head) {
        if (head == null) {
            return;
        }

        if (head.getNext() == null) {
            System.out.println(head.getValue());
        }

        ListNode l1 = head;
        ListNode l2 = head.getNext();
        head.setNext(null);

        while (l2.getNext() != null) {
            ListNode l3 = l2.getNext();
            l2.setNext(l1);
            l1 = l2;
            l2 = l3;
        }
        l2.setNext(l1);

        while (l2 != null) {
            System.out.print(l2.getValue() + " ");
            l2 = l2.getNext();
        }
    }
}
