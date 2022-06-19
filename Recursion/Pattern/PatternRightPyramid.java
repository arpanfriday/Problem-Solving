public class PatternRightPyramid {
    static void rightPyramid(int n, int row) {
        if (row > n)
            return;
        int space = n - row;
        printSpace(space);
        printStar(1, row);
        System.out.println();
        rightPyramid(n, row + 1);
    }

    static void printSpace(int space) {
        if (space == 0)
            return;
        System.out.print("  ");
        printSpace(space - 1);
    }

    static void printStar(int star, int row) {
        if (star > row)
            return;
        System.out.print("* ");
        printStar(star + 1, row);
    }

    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        rightPyramid(n, row);
    }
}
