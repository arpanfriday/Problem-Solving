public class PatternDiamond {
    static void upperHalf(int n, int row) {
        if (row > n) {
            lowerHalf(n, row - 2);
            return;
        }
        int space = n - row;
        printSpace(space);
        printStar(1, (2 * row) - 1);
        System.out.println();
        upperHalf(n, row + 1);
    }

    static void lowerHalf(int n, int row) {
        if (row < 0)
            return;
        int space = n - row;
        printSpace(space);
        printStar(1, (2 * row) - 1);
        System.out.println();
        lowerHalf(n, row - 1);
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
        int n = 9;
        int row = 1;
        upperHalf((n / 2) + 1, row);
    }
}
