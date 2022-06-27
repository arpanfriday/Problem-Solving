public class JosephesProblem {
    static int jp(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int newPos = jp(n - 1, k); // k is fixed. Onl reduce the circle size
        return (newPos + k) % n;
    }

    public static void main(String[] args) {
        int r = jp(5, 3);
        System.out.println(r);
    }
}
