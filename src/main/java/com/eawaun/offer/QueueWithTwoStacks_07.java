package com.eawaun.offer;

import com.eawaun.offer.stack.Stack;

public class QueueWithTwoStacks_07 {
    public static void main(String[] args) {
        CQueue<Integer> queue = new CQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.appendTail(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(queue.deleteHead() + " ");
        }
        System.out.println();
    }
}

class CQueue<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void appendTail(T item) {
        stack1.push(item);
    }

    public T deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}