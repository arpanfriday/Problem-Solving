public class EditDistance {
    static int editDistanceOperationCount(String first, String second, int m, int n) {
        // termination case
        // if fitsr strign exhused
        if (m == 0)
            return n; // return length of second and it becomes nomber of operations left
        if (n == 0)
            return m;

        // current character match
        if (first.charAt(m - 1) == second.charAt(n - 1)) {
            // move to next character. Do nothing
            return editDistanceOperationCount(first, second, m - 1, n - 1);
        }
        // if characters not match so we have three choices
        // 1st choice- insert
        int insert = editDistanceOperationCount(first, second, m - 1, n);
        int delete = editDistanceOperationCount(first, second, m, n - 1);
        int replace = editDistanceOperationCount(first, second, m - 1, n - 1);
        // get minimum of all operations
        int min = Math.min(insert, Math.min(delete, replace));
        return 1 + min;
    }

    static int[][] mat;

    static void printMat(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static int tabulation(String first, String second, int m, int n) {
        mat = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            mat[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            mat[i][0] = i;
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[i].length; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    mat[i][j] = mat[i - 1][j - 1];
                else
                    mat[i][j] = 1 + Math.min(mat[i - 1][j - 1], Math.min(mat[i - 1][j], mat[i][j - 1]));
            }
        }
        printMat(mat);
        return mat[m][n];
    }

    public static void main(String[] args) {
        String first = "Sunday";
        String second = "Saturday";
        int count = editDistanceOperationCount(first, second, first.length(), second.length());
        System.out.println("Recursion: " + count);
        System.out.println("Tabulation: " + tabulation(first, second, first.length(), second.length()));
    }
}
