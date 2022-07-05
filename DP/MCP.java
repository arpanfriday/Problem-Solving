public class MCP {

    static int tabulation(int costMatrix[][]) {
        int matrix[][] = new int[costMatrix.length][costMatrix.length];
        matrix[0][0] = costMatrix[0][0];
        // first fill the first row
        for (int i = 1; i < matrix.length; i++) {
            matrix[0][i] = matrix[0][i - 1] + costMatrix[0][i];
        }
        // fill the first column
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] + costMatrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                int diagonal = matrix[i - 1][j - 1];
                int left = matrix[i][j - 1];
                int up = matrix[i - 1][j];
                matrix[i][j] = costMatrix[i][j] + Math.min(up, Math.min(diagonal, left));
            }
        }
        return matrix[matrix.length - 1][matrix.length - 1];
    }

    static int mcp(int costMatrix[][], int row, int col) {
        // termination case
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }
        if (row == 0 && col == 0) {
            return costMatrix[row][col];
        }
        // small problem
        int diagonal = mcp(costMatrix, row - 1, col - 1);
        int right = mcp(costMatrix, row, col - 1);
        int down = mcp(costMatrix, row - 1, col);
        return costMatrix[row][col] + Math.min(down, Math.min(diagonal, right));
    }

    public static void main(String[] args) {
        int costMatrix[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        int result = mcp(costMatrix, 2, 2);
        System.out.println("Recursion: " + result);
        result = tabulation(costMatrix);
        System.out.println("Tabulation: " + result);
    }
}
