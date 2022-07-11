import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerElement {
    static void stackNextGreater(int arr[]) {
        ArrayList<Integer> aux = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        aux.add(-1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            int nextSmallerElement = stack.empty() ? -1 : stack.peek();
            aux.add(nextSmallerElement);
            stack.push(arr[i]);
        }
        Collections.reverse(aux);
        System.out.println(aux);
    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 2, 25 };
        int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
        stackNextGreater(arr);
    }
}
