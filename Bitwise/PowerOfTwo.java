import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        if (count == 1) {
            System.out.println("Yes, power of 2");
        } else {
            System.out.println("No, not a power of 2");
        }
    }
}
