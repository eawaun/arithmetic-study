package com.eawaun.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个队列实现栈
 */
public class StackWithQueue_07_2 {
    public static void main(String[] args) {
        CStack<Integer> stack = new CStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class CStack<T> {
    private Queue<T> queue;

    public CStack() {
        this.queue = new LinkedList<>();
    }

    public void push(T item) {
        this.queue.add(item);
    }

    public T pop() {
        if (queue.size() == 0) {
            throw new RuntimeException("queue is empty");
        }

        if (queue.size() == 1) {
            return queue.poll();
        }

        int pollTimes = queue.size() - 1;
        while (pollTimes-- > 0) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }
}