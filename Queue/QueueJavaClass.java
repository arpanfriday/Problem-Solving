import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJavaClass {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10); // enqueue
        queue.offer(20);
        System.out.println(queue.peek()); // front element
        System.out.println(queue.poll()); // dequeue
        System.out.println(queue.peek()); // front element
    }
}
