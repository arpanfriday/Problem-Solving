package DSA_Queue;

import java.util.Queue;

public class StackUsingQueue {
    Queue<E> primaryQueue = new Queue(10);
    Queue secondaryQueue = new Query(10);

    void push(int element) {
        while (!primaryQueue.isEmpty()) {
            secondaryQueue.enqueue(primaryQueue.dequeue());
        }
        primaryQueue.enqueue(element);
        while (!secondaryQueue.isEmpty()) {
            primaryQueue.enqueue(secondaryQueue.dequeue());
        }
    }

    int pop() {
        return primaryQueue.dequeue();
    }

    public static void main(String[] args) {

    }
}
