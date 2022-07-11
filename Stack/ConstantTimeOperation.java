import java.util.Stack;
import java.util.Scanner;

public class ConstantTimeOperation {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> aux = new Stack<>();

    static void addElement(int num) {
        if ((stack.isEmpty() && aux.isEmpty()) || (num < aux.peek())) {
            stack.push(num);
            aux.push(num);
            return;
        } else {
            stack.push(num);
        }
    }

    static void deleteElement() {
        if (stack.peek() == aux.peek()) {
            stack.pop();
            aux.pop();
        } else {
            stack.pop();
        }
    }

    static int getMinimimElement() {
        return aux.peek();
    }

    static void print() {
        System.out.println(stack);
        System.out.println(aux);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("|   1. Add to stack");
            System.out.println("|   2. Delete from stack");
            System.out.println("|   3. Get minimum element");
            System.out.println("|   4. Print stack");
            System.out.println("|   10 Exit");
            System.out.print("|   Enter the choice: ");
            int choice = sc.nextInt();
            int data;
            switch (choice) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter the data: ");
                    data = sc.nextInt();
                    addElement(data);
                    sc.close();
                    break;
                case 2:
                    deleteElement();
                    break;
                case 3:
                    System.out.println(getMinimimElement());
                    break;
                case 4:
                    print();
                    break;
                case 10:
                    return;
                default:
                    break;
            }
        }
    }
}