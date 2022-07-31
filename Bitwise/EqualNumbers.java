import java.util.Scanner;

public class EqualNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if ((num1 ^ num2) == 0) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
        sc.close();
    }
}
