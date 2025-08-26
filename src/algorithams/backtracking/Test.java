package algorithams.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

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
       String digits = "23";
       System.out.println(letterCombinations(digits));
    }


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(),result);
        return result;
    }

    public static void letterCombinations(String digits, int index,StringBuilder sb ,List<String> result ) {
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        char curDigit = digits.charAt(index);
        for (char ch:KEYBOARD.get(curDigit)) {
            sb.append(ch);
            letterCombinations(digits,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }



}


