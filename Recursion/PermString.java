import java.util.ArrayList;

public class PermString {
    static ArrayList<String> Perm(String str) {
        // termination case
        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(" ");
            return list;
        }
        // get single char (stack fall)
        char singleChar = str.charAt(0);
        // make small string
        String subString = str.substring(1);
        ArrayList<String> result = Perm(subString);
        ArrayList<String> finalResult = new ArrayList<>();
        // We create permutation
        for (String s : result) {
            for (int i = 0; i < s.length(); i++) {
                StringBuffer sb = new StringBuffer(s);
                sb.insert(i, singleChar);
                finalResult.add(sb.toString());
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(Perm("abc"));
    }
}
