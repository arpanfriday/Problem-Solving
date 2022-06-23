import java.util.Scanner;

public class Palindrome {
    static String isPalindrome(String str) {
        if (str.length() == 0)
            return "";
        char singleChar = str.charAt(0);
        return isPalindrome(str.substring(1)) + singleChar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.equals(isPalindrome(str))) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        sc.close();
    }
}
