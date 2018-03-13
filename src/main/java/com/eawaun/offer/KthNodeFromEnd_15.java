package com.eawaun.offer;

import com.eawaun.offer.list.ListNode;

public class KthNodeFromEnd_15 {
    public static ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode prePoint = head;
        ListNode postPoint = head;

        for (int i = 0; i < k - 1; i++) {
            if (prePoint.getNext() != null) {
                prePoint = prePoint.getNext();
            } else {
                return null;
            }
        }

        while (prePoint.getNext() != null) {
            prePoint = prePoint.getNext();
            postPoint = postPoint.getNext();
        }
        return postPoint;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        ListNode p = findKthNodeFromEnd(head, 4);
        System.out.println(p.getValue());
    }
}
