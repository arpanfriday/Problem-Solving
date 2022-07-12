class Queue {
    int data[];
    int front;
    int rear;
    int size;

    Queue(int capacity) {
        data = new int[capacity];
        front = rear = -1;
        size = 0; // Queue is empty
    }

    void enqueue(int element) {
        // If queue is full
        if (size == data.length)
            throw new RuntimeException("Queue is full");
        // Is queue is empty
        if (size == 0)
            front = 0;
        rear++;
        size++;
        if (rear == data.length)
            rear = 0;
        data[rear] = element;
    }

    int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        int frontElement = data[front];
        front++;
        if (front == data.length) {
            front = 0;
        }
        size--;
        if (size == 0) {
            front = rear = -1;
        }
        return frontElement;
    }

    int getSize() {
        return size;
    }

    int getFront() {
        if (getSize() == 0) {
            throw new RuntimeException("No front! Queue is empty");
        }
        return data[front];
    }

    boolean isEmpty() {
        return size == 0;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getFront());

        queue.enqueue(10);

    }
}
