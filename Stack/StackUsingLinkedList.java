import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;

    Node(T data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class DoublyLinkedListOperations<T> {
    Node<T> start;

    void print() {
        Node<T> temp = start;
        System.out.println("**********************");
        if (start == null)
            System.out.print("LL is empty");
        else
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        System.out.println();
        System.out.println("**********************");
    }

    void add(Node<T> node) {
        if (start == null) {
            start = node;
        } else {
            Node<T> temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
        print();
    }

    void delete() {
        if (start == null) {
            System.out.println("List is empty!!");
            return;
        }
        if (start.next == null) {
            start = null;
            print();
            return;
        }
        Node<T> temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp = null;
        print();
    }

    int peek() {
        if (start == null) {
            throw new RuntimeException("LL is empty. Nothing to peek");
        }
        Node<T> temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (int) temp.data;
    }

    boolean isEmpty() {
        if (start == null)
            return true;
        return false;
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        DoublyLinkedListOperations<Integer> opr = new DoublyLinkedListOperations<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("|   1. Add in the ending");
            System.out.println("|   2. Delete at ending");
            System.out.println("|   3. Peek element");
            System.out.println("|   4. Check if stack is empty");
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
                    opr.add(node);
                    break;
                case 2:
                    opr.delete();
                    break;
                case 3:
                    System.out.println(opr.peek());
                    break;
                case 4:
                    System.out.println(opr.isEmpty());
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
