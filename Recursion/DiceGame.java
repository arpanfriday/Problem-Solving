import java.util.ArrayList;

public class DiceGame {
    static ArrayList<String> reachToTen(int currentValue, int endValue) {
        // temination value
        if (currentValue == endValue) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        // negative case or boundary case
        if (currentValue > endValue) {
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        // dice roll 1 to 6 times
        ArrayList<String> finalResult = new ArrayList<>();
        for (int dice = 1; dice <= 6; dice++) {
            // small problem
            // current value + dice
            int newValue = currentValue + dice;
            ArrayList<String> result = reachToTen(newValue, endValue);
            for (String s : result) {
                finalResult.add(s + dice);
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        ArrayList<String> result = reachToTen(0, 10);
        System.out.println(result);
    }
}
