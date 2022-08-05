import java.util.Scanner;

class Node<T> {
    Node<T> prev;
    T data;
    Node<T> next;

    Node(T data) {
        prev = null;
        this.data = data;
        next = null;
    }
}

class LinkedListOperations<T> {
    // we need a start pointer(Reference of the first node)
    Node<T> start; // default initialised with null
    Node<T> end;
    // Print the LL

    void printFromStart() {
        Node<T> temp = start;
        System.out.println("**********************");
        System.out.println("Left to right");
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

    void printFromEnd() {
        Node<T> temp = end;
        System.out.println("**********************");
        System.out.println("Right to left");
        if (temp == null)
            System.out.print("LL is empty");
        else
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
        System.out.println();
        System.out.println("**********************");
    }

    void addAtBeg(Node<T> node) {
        if (start == null) {
            start = node;
            end = node;
        } else {
            start.prev = node;
            node.next = start;
            node.prev = null;
            start = node;
        }
        printFromStart();
        printFromEnd();
    }

    void addAtEnd(Node<T> node) {
        if (start == null) {
            // It means LL is empty
            start = node; // node reference will be copied to the start node
            end = node;
        } else {
            // LL is not empty
            Node<T> temp = start; // first node reference copied to the temp node
            // temp node is pointing to first node
            while (temp.next != null) {
                temp = temp.next; // traverse node by node
            }
            temp.next = node;
            node.prev = temp;
            node.next = null;
            end = node;
        }
        printFromStart();
        printFromEnd();
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
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
        printFromStart();
        printFromEnd();
    }

    void deleteAtBeg() {
        if (start == null) {
            System.out.println("List is empty!!");
            return;
        }
        if (start.next == null) {
            start = null;
            return;
        }
        Node<T> temp = start;
        start = start.next;
        start.prev = null;
        temp.next = null;
        temp = null;
        printFromStart();
        printFromEnd();
    }

    void deleteAtEnd() {
        if (start == null) {
            System.out.println("List is empty!!");
            return;
        }
        if (start.next == null) {
            start = null;
            return;
        }
        Node<T> temp = end.prev;
        end.prev.next = null;
        end.prev = null;
        end = temp;
        printFromStart();
        printFromEnd();
    }

    void deleteAtMiddle(int position) {
        if (start == null) {
            System.out.println("List is empty!!");
            return;
        }
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
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
        printFromStart();
        printFromEnd();
    }
}

public class DoubleLinkedList {
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
                    sc.close();
                    return;
                default:
                    break;
            }
        }
    }
}
