public class ClimbingStairs {
    static int getStairs(int currentStair, int endStair) {
        if (currentStair == endStair) {
            return 1;
        }
        if (currentStair > endStair) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= 2; i++) {
            int newStair = currentStair + i;
            count += getStairs(newStair, endStair);
        }
        return count;
    }

    static int getStairsDP(int n) {
        if (n == 1)
            return 1;
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[n - 1] + arr[n - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 3;
        int result = getStairs(start, end);
        System.out.println(result);

        result = getStairsDP(end);
        System.out.println(result);
    }
}
