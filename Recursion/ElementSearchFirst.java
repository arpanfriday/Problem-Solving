import java.util.Scanner;

public class ElementSearchFirst {
    static int getIndex(int arr[], int index, int num) {
        if (index > arr.length - 1)
            return -1;
        if (arr[index] == num)
            return index;
        return getIndex(arr, index + 1, num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = sc.nextInt();
        System.out.println("Enter elements: ");
        int arr[] = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = sc.nextInt();
        System.out.print("Enter element to search at last: ");
        int num = sc.nextInt();
        System.out.println(getIndex(arr, 0, num));
        sc.close();
    }
}
