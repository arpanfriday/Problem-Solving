import java.util.Scanner;

public class SumOfDigit {
    static int sum(int n) {
        if (n == 0)
            return 0;
        return n % 10 + sum(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        System.out.println("Sum: " + sum(sc.nextInt()));
        sc.close();
    }
}
