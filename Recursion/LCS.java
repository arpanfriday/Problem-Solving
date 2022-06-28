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

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int len = lcsRec(str1, str2, str1.length() - 1, str2.length() - 1);
        System.out.println(len);
    }
}
