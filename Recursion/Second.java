public class Second {
    static void printNum(int n) {
        if (n == 0) {
            return;
        }
        if (n % 2 != 0)
            System.out.print(n + " ");
        printNum(n - 1);
        if (n % 2 == 0)
            System.out.print(n + " ");
    }

    public static void main(String[] args) {
        printNum(5);
    }
}
