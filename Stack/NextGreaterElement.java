import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {

    static void stackNextGreater(int arr[]) {
        ArrayList<Integer> aux = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        // System.out.print(-1 + " ");
        aux.add(-1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int nextGreaterElement = stack.empty() ? -1 : stack.peek();
            // System.out.print(nextGreaterElement + " ");
            aux.add(nextGreaterElement);
            stack.push(arr[i]);
        }
        Collections.reverse(aux);
        System.out.println(aux);
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 2, 25 };
        // approach1(arr);
        stackNextGreater(arr);
    }
}
