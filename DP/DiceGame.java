public class DiceGame {
    static int countWays(int currentValue, int endValue) {
        // termination case
        if (currentValue == endValue) {
            return 1;
        }
        if (currentValue > endValue) {
            return 0;
        }
        int count = 0; // for each recursive call count set to 0
        for (int dice = 1; dice <= 6; dice++) {
            int newValue = currentValue + dice; // small problem
            count += countWays(newValue, endValue);
        }
        return count;
    }

    static int countWaysMemo(int currentValue, int endValue, int[] cache) {
        // termination case
        if (currentValue == endValue) {
            return 1;
        }
        if (currentValue > endValue) {
            return 0;
        }

        if (cache[currentValue] != 0) {
            return cache[currentValue];
        }

        int count = 0; // for each recursive call count set to 0
        int newValue = 0;
        for (int dice = 1; dice <= 6; dice++) {
            newValue = currentValue + dice; // small problem
            count += countWaysMemo(newValue, endValue, cache);
        }
        cache[currentValue] = count;
        return count;
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 10;
        int count = countWays(start, end);
        System.out.println(count);

        int cache[] = new int[end + 1];
        count = countWaysMemo(start, end, cache);
        System.out.println(count);
    }
}
