public class PatternAlphaNum2 {
    static void alphaNUm(int n, int row, char ch) {
        if (row > n)
            return;
        printStar(row, ch);
        System.out.println();
        alphaNUm(n, row + 1, ++ch);
    }

    static void printStar(int numOfStars, char ch) {
        if (numOfStars == 0)
            return;
        System.out.print(ch + " ");
        printStar(numOfStars - 1, ch);
    }

    public static void main(String[] args) {
        int n = 5;
        int row = 1;
        alphaNUm(n, row, 'A');
    }
}
