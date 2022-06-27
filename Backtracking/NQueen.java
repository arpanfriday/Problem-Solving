public class NQueen {
    static boolean canIPlaceAQueen(boolean board[][], int currentRow, int currentCol) {
        // COnstraint check
        // 1. Check for same column
        for (int i = currentRow; i >= 0; i--)
            if (board[i][currentCol])
                return false;

        // 2. Check for upper left diagonal
        for (int i = currentRow, j = currentCol; i >= 0 && j >= 0; i--, j--)
            if (board[i][j])
                return false;
        // 3. Check in same diagonal
        for (int i = currentRow, j = currentCol; i >= 0 && j < board.length; i--, j++)
            if (board[i][j])
                return false;

        return true;
    }

    static int countNumOfWaysToPlaceQueen(boolean board[][], int currentRow) {
        int count = 0;
        // Termination case
        if (currentRow == board.length) {
            return 1; // complete travarsal done. Hence a way is found
        }
        // 1st step: traverse the columns
        for (int cols = 0; cols < board[currentRow].length; cols++) {
            // Place a queen in a cell
            if (canIPlaceAQueen(board, currentRow, cols)) {
                board[currentRow][cols] = true;
                count += countNumOfWaysToPlaceQueen(board, currentRow + 1);
                // Backtrack
                board[currentRow][cols] = false; // undo the changes
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 4x4 boolean matrix
        boolean[][] board = new boolean[4][4];
        int ways = countNumOfWaysToPlaceQueen(board, 0);
        System.out.println(ways);
    }
}
