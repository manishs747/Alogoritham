package algorithams.backtracking.neetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {

    public static void main(String[] args) {
        String digits = "234";
       // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(digits));
    }


    public static Map<Character,String> map = new HashMap<>();
    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

    }

    public  static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        letterCombinations(digits, new StringBuilder(),result );
        return result;
    }

    public static void letterCombinations(String digits , StringBuilder sb,List<String> result)  {
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        String letterStr = map.get(digits.charAt(sb.length()));
        for(char c : letterStr.toCharArray()){
            sb.append(c);
            letterCombinations(digits, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
