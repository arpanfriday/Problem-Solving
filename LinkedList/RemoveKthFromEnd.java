import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
    }

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
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

    void KthfromEnd(int k) {
        if (start == null) {
            System.out.println("LL is empty");
            return;
        }
        if (start.next == null) { // if list contains only one element
            start = null;
            System.out.println("List is empty now");
            return;
        }
        Node<T> temp = new Node(-1, start);
        Node<T> p = temp;
        Node<T> q = temp;
        for (int i = 1; i <= k; i++) {
            q = q.next;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        if (p.next == start) { // true only when there are two elements in the list
            start = start.next;
        } else {
            p.next = p.next.next;
        }
    }

    void print() {
        Node<T> temp = start;
        System.out.println("******************");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("******************");
        System.out.println();
    }
}

public class RemoveKthFromEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperations<Integer> opr = new LinkedListOperations<>();
        while (true) {
            System.out.println("1. Add element at the end of Linked List");
            System.out.println("2. Delete the Kth Element from the end");
            System.out.println("3. Print the Linked List");
            System.out.println("10. Exit");
            System.out.println("Enter the choice: ");
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
                    System.out.print("Which element from last you want to delete: ");
                    opr.KthfromEnd(sc.nextInt());
                    break;
                case 3:
                    opr.print();
                    break;
                case 10:
                    sc.close();
                    return;
            }
        }
    }
}
