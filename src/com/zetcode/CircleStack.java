package com.zetcode;

import java.util.LinkedList;

public class CircleStack<T> {
    private int                 stackSize;
    private LinkedList<T> stack;

    public CircleStack(int size) {
        this.stackSize = size;
        this.stack     = new LinkedList<>();
    }

    public void push(T element) {
        if (stack.size() == stackSize) {
            stack.removeLast();
        }

        stack.addFirst(element);
    }

    public T pop() {
        if (stack.isEmpty()) { // 비어있으면 0을 리턴함
            return null;
        }

        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
