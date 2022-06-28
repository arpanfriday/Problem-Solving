public class LCS {
    static int lcsRec(String first, String second, int m, int n) {
        // termination case
        if (m == -1 || n == -1)
            return 0;
        int count = 0;
        if (first.charAt(m) == second.charAt(n)) {
            count = 1 + lcsRec(first, second, m - 1, n - 1);
            return count;
        } else {
            int x = lcsRec(first, second, m, n - 1);
            int y = lcsRec(first, second, m - 1, n);
            return Math.max(x, y);
        }
    }

    static int lcsMemo(String first, String second, int m, int n, int cache[][]) {
        // termination case
        if (m == 0 || n == 0)
            return 0;
        if (cache[m - 1][n - 1] != 0)
            return cache[m - 1][n - 1];
        int count = 0;
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            count = 1 + lcsMemo(first, second, m - 1, n - 1, cache);
            cache[m - 1][n - 1] = count;
            return count;
        } else {
            int x = lcsMemo(first, second, m, n - 1, cache);
            int y = lcsMemo(first, second, m - 1, n, cache);
            count = Math.max(x, y);
            cache[m - 1][n - 1] = count;
            return count;
        }
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int len = lcsRec(str1, str2, str1.length() - 1, str2.length() - 1);
        System.out.println(len);

        int[][] cache = new int[str1.length()][str2.length()];
        len = lcsMemo(str1, str2, str1.length(), str2.length(), cache);
        System.out.println(len);
    }
}
