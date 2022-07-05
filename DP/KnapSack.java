public class KnapSack {
    static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] matrix;

    static int tabulation(int prices[], int weights[], int maxWeight, int totalItems) {
        matrix = new int[totalItems + 1][maxWeight + 1];
        // fill the 0th row and 1st column for base case
        for (int i = 0; i <= maxWeight; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i <= totalItems; i++) {
            matrix[i][0] = 0;
        }

        for (int i = 1; i <= totalItems; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weights[i - 1] > j) { // given weight is greater than the max weight in that column
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    int option1 = prices[i - 1] + matrix[i - 1][j - weights[i - 1]];
                    int option2 = matrix[i - 1][j];
                    matrix[i][j] = Math.max(option1, option2);
                }
            }
        }
        return matrix[totalItems][maxWeight];
    }

    static int knapsack01(int[] weights, int[] prices, int maxWeight, int index) {
        if (index == weights.length || maxWeight == 0) { // bag full
            return 0;
        }
        // First thing is
        // put the value in the bag if there is capacity, else
        // if current weight of item is > maxCapacity then bypass
        if (weights[index] > maxWeight) {
            return knapsack01(weights, prices, maxWeight, index + 1);
        }
        // No current item is > maxWeight, then item can come in bag
        else {
            int option1 = prices[index] + knapsack01(weights, prices, maxWeight - weights[index], index + 1);
            int option2 = knapsack01(weights, prices, maxWeight, index + 1);
            return Math.max(option1, option2);
        }
        // Pick value to place in a bag
        // Not pick value to place in a bag
    }

    public static void main(String[] args) {
        int maxWeight = 8; // Maximum we have 3kg bag
        int prices[] = { 1, 2, 5, 6 };
        int weights[] = { 2, 3, 4, 5 };
        int maxProfit = knapsack01(weights, prices, maxWeight, 0);
        System.out.println("Recursion: " + maxProfit);
        maxProfit = tabulation(prices, weights, maxWeight, prices.length);
        System.out.println("Tabulation: " + maxProfit);
        System.out.println("Tabulation matrix:");
        System.out.println();
        printMatrix(matrix);
    }
}
