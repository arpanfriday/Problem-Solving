public class SortedOrNot {
    static boolean isSorted(int[] arr, int i) {
        if (i == 1) {
            if (arr[i] > arr[i - 1])
                return true;
            return false;
        }
        return (arr[i] > arr[i - 1]) && isSorted(arr, i - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 12, 13, 14, 15 };
        System.out.println(isSorted(arr, arr.length - 1));
    }
}
