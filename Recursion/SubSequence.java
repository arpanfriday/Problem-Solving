import java.util.ArrayList;

public class SubSequence {
    static ArrayList<String> getSubSequence(String name) {
        // termination case
        if (name.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(name);
            return list;
        }
        // get single character which is used to join in the arraylist when stack falls
        char singleChar = name.charAt(0);
        // Make the string small till we reach empty string ""
        String subString = name.substring(1); // pck string from first index till end
        ArrayList<String> result = getSubSequence(subString);
        ArrayList<String> finalResult = new ArrayList<>();
        for (String s : result) {
            finalResult.add(s);
            finalResult.add(singleChar + s);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        String str = "amit";
        ArrayList<String> result = getSubSequence(str);
        System.out.println(result);
    }
}
