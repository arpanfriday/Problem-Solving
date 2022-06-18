import java.util.ArrayList;
import java.util.Collections;

public class FindOccuranceInArray {
    static ArrayList<Integer> getIndex(int arr[], int index, ArrayList<Integer> res, int num) {
        if (index < 0)
            return res;
        if (arr[index] == num)
            res.add(index);
        return getIndex(arr, index - 1, res, num);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 4, 2, 8, 2 };
        int key = 2;
        ArrayList<Integer> res = new ArrayList<>();
        Collections.reverse(getIndex(arr, arr.length - 1, res, key));
        System.out.println(res);
    }
}
