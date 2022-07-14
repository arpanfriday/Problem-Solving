import java.util.Stack;
import java.util.Scanner;

public class ConstantTimeOperation2 {
    static Stack<Integer> stack = new Stack<>();
    static int min = 0;

    static void push(int element) {
        if (stack.empty()) {
            min = element;
            stack.push(element);
        } else if (element <= min) {
            stack.push(element - min);
            min = element;
        } else {
            stack.push(element);
        }
    }

    static int getMinimimElement() {
        return min;
    }

    static int pop() {
        int element = stack.pop();
        if (element < 0) {
            int result = min;
            min = min - element;
            return result;
        } else {
            return element;
        }
    }

    public static void main(String[] args) {
        stack.push(5);
        stack.push(10);
        stack.push(20);
        stack.push(2);
        stack.push(7);
        System.out.println(getMinimimElement());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(getMinimimElement());
    }
}