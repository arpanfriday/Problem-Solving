public class Fibonacci {
    static int fibb(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return fibb(n - 1) + fibb(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibb(20));
    }
}
