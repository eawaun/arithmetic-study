package com.eawaun.offer;

import com.eawaun.offer.list.ListNode;

/**
 * 给定一个链表和链表中的一个节点，在O(1)时间内删除这个节点
 */
public class DeleteNodeInList_13 {

    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }

        if (toBeDeleted.getNext() != null) {
            ListNode nextNode = toBeDeleted.getNext();
            toBeDeleted.setValue(nextNode.getValue());
            toBeDeleted.setNext(nextNode.getNext());
        } else if (head == toBeDeleted) {
            head = null;
        } else {
            //删除尾节点
            ListNode current = head;
            while (current.getNext() != toBeDeleted) {
                current = current.getNext();
            }
            current.setNext(null);
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
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

        printList(head);

        deleteNode(head, node3);
        printList(head);

        deleteNode(head, node5);
        printList(head);
    }
}
