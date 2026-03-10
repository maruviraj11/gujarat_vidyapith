package org.gvp.dcs.ds;

public class Queue {
    private int[] queue;
    private int front, rear, size;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = -1;
    }

    public void enqueue(int value) {
        if (rear == size - 1) {
            System.out.println("Queue is Full!");
        } else {
            if (front == -1) front = 0;
            queue[++rear] = value;
            System.out.println(value + " added to queue.");
        }
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty!");
            return -1;
        } else {
            return queue[front++];
        }
    }

    public int peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is Empty!");
            return -1;
        } else {
            return queue[front];
        }
    }
}
