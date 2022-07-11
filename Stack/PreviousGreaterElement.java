import java.util.Stack;

public class PreviousGreaterElement {
    // 2 loops
    // Outer loop traverse each element
    // Inner loop find the previous greater element
    static void approach1(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    break;
                }
            }
            if (j == -1)
                System.out.print("-1 ");
        }
    }

    static void stackApproach(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() < arr[i]) {
                stack.pop();
            }
            int PreviousGreaterElement = stack.empty() ? -1 : stack.peek();
            System.out.print(PreviousGreaterElement + " ");
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
        // approach1(arr);
        stackApproach(arr);
    }
}
