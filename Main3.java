import java.util.Scanner;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int numElements;

    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        numElements = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        numElements++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = queueArray[front];
        front = (front + 1) % maxSize;
        numElements--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public boolean isFull() {
        return numElements == maxSize;
    }

    public int size() {
        return numElements;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued item: " + queue.dequeue());
        System.out.println("Peeked item: " + queue.peek());

        System.out.println("Queue size: " + queue.size());
    }
}
