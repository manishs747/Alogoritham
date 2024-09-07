package algorithams.backtracking.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LetterCombinationsPN {

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
        String  digits = "23";
       // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(digits));
    }


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits,0,new ArrayList<>(),result);
        return result;
    }

    public static void letterCombinations(String digits,int counter , List<String> path ,List<String> result ) {
    if(counter >= digits.length()){
        result.add(String.join("", path));
        return;
    }
        char[] alpa = KEYBOARD.get(digits.charAt(counter));
        for (char c:alpa) {
            path.add(c+"");
            letterCombinations(digits,counter+1,path,result);
            path.remove(path.size()-1);
        }
    }

}
