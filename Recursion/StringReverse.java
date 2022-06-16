import java.util.Scanner;

public class StringReverse {
    static void reverse(String s) {
        if (s.length() == 0)
            return;
        System.out.print(s.charAt(s.length() - 1));
        reverse(s.substring(0, s.length() - 1));
        return;
    }

    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        reverse(new Scanner(System.in).next());
    }
}
