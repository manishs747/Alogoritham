package algorithams.backtracking.online;

import java.util.*;
/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {



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
         backtrack(digits,0,new StringBuilder(),result);
         return result;
    }

    private static void backtrack(String digits, int index, StringBuilder path ,List<String> result ) {
        if(digits.isEmpty()) return;
        if(digits.length() == index){
            result.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        for (char letter:KEYBOARD.get(digit)) {
            path.append(letter);
            backtrack(digits,index+1,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }


















    public static List<String> letterCombinationsBackTracking(String digits) {
        ArrayList<String> result = new ArrayList<>();
       letterCombinationsBackTracking(digits.toCharArray(),new StringBuilder(),result);
       return result;
    }


    public static void letterCombinationsBackTracking(char[] digits , StringBuilder path, ArrayList<String> result) {
        if(path.length() == digits.length){
            result.add(path.toString());
            return;
        }
        char next_digit =  digits[path.length()];
        for (char c:KEYBOARD.get(next_digit)) {
            path.append(c);
            letterCombinationsBackTracking(digits,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }

/****************************************DFS//cascading******************************************************************/
    public List<String> letterCombinations2(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        return dfs2(digits, 0);
    }


    public static List<String> dfs2(String digits, int index) {
        if (index == digits.length()) return Arrays.asList("");
        List<String> result = new ArrayList<>();
        char[] currentKeyWord = KEYBOARD.get(digits.charAt(index));
        List<String> childrenResultList = dfs2(digits, index + 1);
        for (int i = 0; i < currentKeyWord.length; i++) {
            for (String str : childrenResultList)
                result.add(currentKeyWord[i] + str);
        }
        return result;
    }
}
