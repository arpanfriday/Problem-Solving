import java.util.HashMap;
import java.util.Stack;

public class InfixToPrefix {
    static String getPrefix(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put('(', 0);
        map.put(')', 0);
        map.put('^', 5);
        map.put('/', 4);
        map.put('*', 3);
        map.put('+', 2);
        map.put('-', 1);

        System.out.println("Symbol\t\t\tStack\t\t\tResult");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (map.containsKey(str.charAt(i)) || str.charAt(i) == '(' || str.charAt(i) == ')') {
                if (!stack.empty()) {
                    if (str.charAt(i) == ')') {
                        stack.push(str.charAt(i));
                        continue;
                    } else if (str.charAt(i) == '(') {
                        while (stack.peek() != ')') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                        continue;
                    }
                    while (map.get(str.charAt(i)) <= map.get(stack.peek())) {
                        sb.append(stack.pop());
                        if (stack.empty()) {
                            break;
                        }
                    }
                    stack.push(str.charAt(i));
                } else {
                    stack.push(str.charAt(i));
                }
            } else {
                sb.append(str.charAt(i));
            }
            System.out.println(str.charAt(i) + "\t\t\t" + stack + "\t\t\t" + sb);
        }
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // String str = "(A+B/C*(D+E)-F)";
        // String str = "a+b*(c^d-e)^(f+g*h)-i"; // - + a * b ^ - ^ c d e + f * g h i
        String str = "(a+b)*(c+d)"; // * + a b + c d
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        System.out.println(getPrefix(sb.toString()));
    }
}
