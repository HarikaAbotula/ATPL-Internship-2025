package com.aaslin.assignments;

public class CircularQueue {
    private final int size = 6; // size = 5 + 1 (extra space to distinguish full/empty)
    private int[] queue = new int[size];
    private int front = 0;
    private int rear = 0;

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add " + data);
            return;
        }
        queue[rear] = data;
        rear = (rear + 1) % size;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        int removed = queue[front];
        front = (front + 1) % size;
        System.out.println("Dequeued: " + removed);
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element: " + queue[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        int index = front;
        while (index != rear) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularqueue = new CircularQueue();

        circularqueue.enqueue(10);
        circularqueue.enqueue(20);
        circularqueue.enqueue(30);
        circularqueue.enqueue(40);
        circularqueue.enqueue(50); // should be full now

        circularqueue.display();

        circularqueue.dequeue();
        circularqueue.dequeue();

        circularqueue.display();

        circularqueue.enqueue(60);
        circularqueue.enqueue(70); // should wrap around

        circularqueue.display();

        circularqueue.peek();
    }
}


