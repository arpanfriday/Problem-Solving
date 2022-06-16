public class Power {
    static int getPower(int n, int p) {
        // Termination case
        if (p == 1)
            return n;

        // small problem
        int small = getPower(n, p - 1);

        // Processing logic
        return n * small;
    }

    public static void main(String[] args) {
        int res = getPower(2, 5);
        System.out.println(res);
    }
}
