public class Fibonacci {
    static int call = 0;
    static int call2 = 0;

    static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        call++;
        int secondTerm = fibo(n - 1);
        int firstTerm = fibo(n - 2);
        int result = firstTerm + secondTerm;
        return result;
    }

    static int fiboMemo(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        call2++;
        int secondTerm = fiboMemo(n - 1, cache);
        int firstTerm = fiboMemo(n - 2, cache);
        int result = firstTerm + secondTerm;
        // store the computer result
        cache[n] = result;
        return result;
    }

    static int fiboTabu(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibo(n));
        System.out.println("Recursive call: " + call);
        int cache[] = new int[n + 1];
        System.out.println(fiboMemo(n, cache));
        System.out.println("Memoization call: " + call2);
        System.out.println(fiboTabu(n));
    }
}
