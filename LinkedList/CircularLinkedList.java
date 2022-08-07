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
    // we need a start pointer(Reference of the first node)
    Node<T> start; // default initialised with null
    Node<T> tail;
    // Print the LL

    void print() {
        Node<T> temp = tail.next;
        System.out.println("**********************");
        if (temp == null)
            System.out.print("CLL is empty");
        else if (temp == tail)
            System.out.print(temp.data + " ");
        else {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != tail.next);
        }
        System.out.println();
        System.out.println("**********************");
    }

    void addAtBeg(Node<T> node) {
        if (tail == null) {
            tail = node;
            node.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
        }
        print();
    }

    void addAtEnd(Node<T> node) {
        if (tail == null) {
            // It means LL is empty
            tail = node;
            node.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        print();
    }

    void deleteAtBeg() {
        if (tail == null)
            System.out.println("CLL is empty!!");
        if (tail.next == tail) {
            tail = null;
            tail.next = null;
        }
        Node<T> temp = tail.next;
        tail.next = tail.next.next;
        temp.next = null;
        print();
    }

    void deleteAtEnd() {
        if (tail == null)
            System.out.println("CLL is empty!!");
        if (tail.next == tail)
            tail = null;

        Node<T> temp2 = tail.next;
        while (temp2.next != tail) {
            temp2 = temp2.next;
        }
        temp2.next = tail.next;
        tail = temp2;
        print();
    }
}

public class CircularLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperations<Integer> opr = new LinkedListOperations<Integer>();
        while (true) {
            System.out.println("|   1. Add in the end");
            System.out.println("|   2. Add in the begenning");
            System.out.println("|   3. Delete at end");
            System.out.println("|   4. Delete at begenning");
            System.out.println("|   10. Exit");
            System.out.print("|   Enter the choice: ");
            int choice = sc.nextInt();
            int data;
            Node<Integer> node;
            switch (choice) {
                case 1:
                    System.out.print("Enter the data for the node: ");
                    data = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtEnd(node);
                    break;
                case 2:
                    System.out.print("Enter the data for the node: ");
                    data = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtBeg(node);
                    break;
                case 3:
                    opr.deleteAtEnd();
                    break;
                case 4:
                    opr.deleteAtBeg();
                    break;
                case 10:
                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}
