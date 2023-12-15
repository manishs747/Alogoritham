package algorithams.backtracking.online;

import java.util.*;

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
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
       letterCombinations(digits.toCharArray(),new StringBuilder(),result);
       return result;
    }


    public static void letterCombinations( char[] digits , StringBuilder path,ArrayList<String> result) {
        if(path.length() == digits.length){
            result.add(path.toString());
            return;
        }
        char next_digit =  digits[path.length()];
        for (char c:KEYBOARD.get(next_digit)) {
            path.append(c);
            letterCombinations(digits,path,result);
            path.deleteCharAt(path.length()-1);
        }
    }


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
