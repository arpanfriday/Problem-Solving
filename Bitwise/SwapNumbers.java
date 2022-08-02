public class SwapNumbers {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        x = x ^ y ^ (y = x);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
