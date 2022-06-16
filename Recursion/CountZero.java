import java.util.Scanner;

public class CountZero {
    static int count(String n) {
        // Termination condition
        if (n.length() == 0)
            return 0;

        // Small problem
        int small = count(n.substring(0, n.length() - 1));

        // Processing logic
        if (n.charAt(n.length() - 1) == '0')
            return (1 + small);
        else
            return small;

    }

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        System.out.println(count(Integer.toString(new Scanner(System.in).nextInt())));
    }
}
