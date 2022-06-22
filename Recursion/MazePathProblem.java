import java.util.ArrayList;
import java.util.HashSet;

public class MazePathProblem {
    static ArrayList<String> getMazePaths(int currentRow, int currentCol, int endRow, int endCol) {
        // termination case
        if (currentCol == endCol && currentRow == endRow) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        // edge case
        if (currentCol > endCol || currentRow > endRow) {
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        // final result
        ArrayList<String> finalResult = new ArrayList<>();
        // small problem
        // horizontal increment
        ArrayList<String> hResult = getMazePaths(currentRow, currentCol + 1, endRow, endCol);
        for (String r : hResult) {
            finalResult.add("H" + r);
        }
        // vertical increment
        ArrayList<String> vResult = getMazePaths(currentRow + 1, currentCol, endRow, endCol);
        for (String r : vResult) {
            finalResult.add("V" + r);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(
                getMazePaths(0, 0, 2, 2));
    }
}
