package org.gvp.dcs.ds;

public class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack is Full!");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed to stack.");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty!");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty!");
            return -1;
        } else {
            return stack[top];
        }
    }
}
