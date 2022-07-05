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
    // Print the LL

    void print() {
        Node<T> temp = start;
        System.out.println("**********************");
        if (temp == null)
            System.out.print("LL is empty");
        else
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        System.out.println();
        System.out.println("**********************");
    }

    void addAtBeg(Node<T> node) {
        if (start == null) {
            start = node;
        } else {
            node.next = start;
            start = node;
        }
        print();
    }

    void addAtEnd(Node<T> node) {
        if (start == null) {
            // It means LL is empty
            start = node; // node reference will be copied to the start node
        } else {
            // LL is not empty
            Node<T> temp = start; // first node reference copied to the temp node
            // temp node is pointing to first node
            while (temp.next != null) {
                temp = temp.next; // traverse node by node
            }
            temp.next = node;
        }
        print();
    }

    void addAtMiddle(Node<T> node, int position) {
        if (position == 0) {
            addAtBeg(node);
            return;
        }
        Node<T> temp = start;
        int i = 1;
        while (i < position) {
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
        print();
    }

    void deleteAtBeg() {
        if (start == null)
            System.out.println("List is empty!!");
        if (start.next == null) {
            start = null;
            return;
        }
        Node<T> temp = start;
        start = start.next;
        temp.next = null;
        temp = null;
        print();
    }

    void deleteAtEnd() {
        if (start == null)
            System.out.println("List is empty!!");
        if (start.next == null) {
            start = null;
            return;
        }
        Node<T> temp = start;
        Node<T> temp2 = start;
        while (temp.next != null) {
            temp2 = temp;
            temp = temp.next;
        }
        temp2.next = null;
        temp = null;
        print();
    }

    void deleteAtMiddle(int position) {
        if (start == null)
            System.out.println("List is empty!!");
        if (start.next == null) {
            start = null;
            return;
        }
        if (position == 0) {
            deleteAtBeg();
            return;
        }
        int i = 1;
        Node<T> temp = start;
        while (i < position) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        print();
    }
}

public class LinkedListDemo {

    public static void main(String[] args) {
        // Node<String> node = new Node("Arpan");
        Scanner sc = new Scanner(System.in);
        LinkedListOperations<Integer> opr = new LinkedListOperations<Integer>();
        while (true) {
            System.out.println("|   1. Add in the end");
            System.out.println("|   2. Add in the begenning");
            System.out.println("|   3. Add in the middle");
            System.out.println("|   4. Delete at begenning");
            System.out.println("|   5. Delete at ending");
            System.out.println("|   6. Delete at middle");
            System.out.println("|   10. Exit");
            System.out.print("|   Enter the choice: ");
            int choice = sc.nextInt();
            int data;
            int pos;
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
                    System.out.print("Enter the data for the node: ");
                    data = sc.nextInt();
                    System.out.print("Enter the position: ");
                    pos = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtMiddle(node, pos - 1);
                    break;
                case 4:
                    opr.deleteAtBeg();
                    break;
                case 5:
                    opr.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter the node number you want to delete: ");
                    pos = sc.nextInt();
                    opr.deleteAtMiddle(pos - 1);
                    break;
                case 10:
                    return;
                default:
                    break;
            }
            // sc.close();
        }
    }
}
