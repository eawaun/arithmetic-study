package com.eawaun.offer.stack;

public class Stack<E> {

    private Object[] elements;
    private int last;

    public Stack() {
        this(100);//tmp
    }

    public Stack(int size) {
        elements = new Object[size];
    }

    public void push(E item) {
        elements[last++] = item;
    }

    public E pop() {
        if (last > 0) {
            return (E) elements[--last];
        }
        return null;
    }

    public E peek() {
        if (last > 0) {
            int index = last - 1;
            return (E) elements[index];
        }
        return null;
    }

    public boolean isEmpty() {
        return last == 0;
    }
}
