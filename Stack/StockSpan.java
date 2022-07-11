import java.util.Stack;

public class StockSpan {
    static void computeSpan(int prices[]) {
        Stack<Integer> spanStack = new Stack<>();
        spanStack.push(0);
        System.out.print(1 + " ");
        for (int i = 1; i < prices.length; i++) {
            while (!spanStack.empty() && prices[spanStack.peek()] <= prices[i]) {
                spanStack.pop();
            }
            int span = spanStack.empty() ? i + 1 : i - spanStack.peek();
            System.out.print(span + " ");
            spanStack.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 13, 15, 12, 14, 16, 8, 6, 4, 10, 30 };
        computeSpan(arr);
    }
}
