public class PatternAlphaNum3 {
    static void alphaNUm(int n, int row, int num) {
        if (row > n)
            return;
        printStar(row, num);
        System.out.println();
        alphaNUm(n, row + 1, ++num);
    }

    static void printStar(int numOfStars, int num) {
        if (numOfStars == 0)
            return;
        System.out.print(num + " ");
        printStar(numOfStars - 1, num);
    }

    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        alphaNUm(n, row, 1);
    }
}
