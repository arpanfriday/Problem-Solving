public class FindMissingNumber {
    public static void main(String[] args) {
        int arr[] = { 10, 11, 12, 13, 15, 16 };
        int maxXor = 0;
        int elementXor = 0;

        for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
            maxXor ^= i;
        }
        for (int i = 0; i < arr.length; i++) {
            elementXor ^= arr[i];
        }
        System.out.println(elementXor ^ maxXor);
    }
}
