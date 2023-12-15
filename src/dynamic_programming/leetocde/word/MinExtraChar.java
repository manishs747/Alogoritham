package dynamic_programming.leetocde.word;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/extra-characters-in-a-string/description/
 */
public class MinExtraChar {

    public static void main(String[] args) {
       String s = "leetscode";
       String [] dictionary = {"leet","code","leetcode"};
        System.out.println(minExtraChar(s,dictionary));
    }

    public static int minExtraChar(String s, String[] dictionary) {
        return minExtraChar(s,dictionary,new HashMap<>());
    }
    public static int minExtraChar(String s, String[] dictionary, Map<String,Integer> memo) {
        if(s.isEmpty()) return 0;
        if(memo.containsKey(s)) return memo.get(s);
        int minExtraCharacter = s.length();
        for (String prefix:dictionary) {
            int remainResult = s.startsWith(prefix) ?minExtraChar(s.substring(prefix.length()),dictionary,memo) : minExtraChar(s.substring(1),dictionary,memo)+1;
             minExtraCharacter = Math.min(minExtraCharacter,remainResult);
        }
        memo.put(s,minExtraCharacter);
        return minExtraCharacter;
    }


}
