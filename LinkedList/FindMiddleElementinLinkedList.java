import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }
}

class LinkedListOperations<T> {
    Node<T> start;

    void addAtEnd(Node<T> node) {
        if (start == null) {
            start = node;
        } else {
            Node<T> temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void findMiddle() {
        Node<T> slow = start;
        Node<T> fast = start;
        if (start == null) {
            System.out.println("Linked List is empty");
            return;
        }
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    void print() {
        Node<T> temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class FindMiddleElementinLinkedList {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedListOperations<Integer> opr = new LinkedListOperations<>();
            while (true) {
                System.out.println("1. Enter elements at the end of node");
                System.out.println("2. Find the middle element of the Linked List");
                System.out.println("3. Print the Linked List");
                System.out.println("10. Exit");
                System.out.println("Enter the choice");
                int choice = sc.nextInt();
                Node<Integer> node;
                int data;
                switch (choice) {
                    case 1:
                        System.out.println("Enter the data for node");
                        data = sc.nextInt();
                        node = new Node<>(data);
                        opr.addAtEnd(node);
                        break;
                    case 2:
                        opr.findMiddle();
                        break;
                    case 3:
                        opr.print();
                        break;
                    case 10:
                        return;
                }
            }
        }
    }
}