import java.util.ArrayList;

public class ClimbingStairs {
    static ArrayList<String> getStairs(int currentStair, int endStair) {
        if (currentStair == endStair) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if (currentStair > endStair) {
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        ArrayList<String> finalResult = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            int newStair = currentStair + i;
            ArrayList<String> result = getStairs(newStair, endStair);
            for (String s : result) {
                finalResult.add(s + i);
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        ArrayList<String> result = getStairs(0, 4);
        System.out.println(result);
    }
}
