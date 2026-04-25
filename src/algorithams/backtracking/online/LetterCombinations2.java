package algorithams.backtracking.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations2 {

    private static final Map<Character, char[]> KEYBOARD = new HashMap<>();
    static {
        KEYBOARD.put('2', "abc".toCharArray());
        KEYBOARD.put('3', "def".toCharArray());
        KEYBOARD.put('4', "ghi".toCharArray());
        KEYBOARD.put('5', "jkl".toCharArray());
        KEYBOARD.put('6', "mno".toCharArray());
        KEYBOARD.put('7', "pqrs".toCharArray());
        KEYBOARD.put('8', "tuv".toCharArray());
        KEYBOARD.put('9', "wxyz".toCharArray());
    }



    public static void main(String[] args) {
        System.out.println(letterCombinationsBackTrackingNew("23"));
    }

    public static List<String> letterCombinationsBackTrackingNew(String digits) {
            List<String> result = new ArrayList<>();
            letterCombinationsBackTracking(digits, new StringBuilder(), result);
            return result;
    }

    public static void letterCombinationsBackTracking(String digits , StringBuilder path , List<String> result) {
        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }
        for (char ch: KEYBOARD.get(digits.charAt(path.length()))) {
            path.append(ch);
            letterCombinationsBackTracking(digits, path, result);
            path.deleteCharAt(path.length()-1);
        }

    }




}
