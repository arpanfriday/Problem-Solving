import java.util.*;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int rev = 0;
        while (num > 0) {
            rev <<= 1;
            if ((int) (num & 1) == 1)
                rev ^= 1;
            num >>= 1;
        }
        System.out.println("Reversed Bits are: " + rev);
        sc.close();
    }
}
