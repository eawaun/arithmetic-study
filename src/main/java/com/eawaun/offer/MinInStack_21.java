package com.eawaun.offer;

import com.eawaun.offer.stack.Stack;

public class MinInStack_21 {
    private Stack<Integer> stack;
    private Stack<Integer> stackHelp;

    public MinInStack_21() {
        this.stack = new Stack<>();
        this.stackHelp = new Stack<>();
    }

    public void push(int item) {
        stack.push(item);
        if (stackHelp.isEmpty() || item < stackHelp.peek()) {
            stackHelp.push(item);
        } else {
            stackHelp.push(stackHelp.peek());
        }
    }

    public int pop() {
        if (stack.isEmpty() || stackHelp.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stackHelp.pop();
        return stack.pop();
    }

    public int min() {
        if (stack.isEmpty() || stackHelp.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stackHelp.peek();
    }

    public static void main(String[] args) {
        MinInStack_21 stack = new MinInStack_21();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.min());
        stack.push(1);
        System.out.println(stack.min());
    }
}
