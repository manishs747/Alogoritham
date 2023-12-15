package data_structure.strings.online;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
 */
public class WordPattern {

    public static void main(String[] args) {
       String pattern = "abba", s = "dog dog dog dog";
       System.out.println(wordPattern(pattern,s));
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> memo = new HashMap<>();
        Map<String,Character> memo2 = new HashMap<>();
          String[] words = s.split("\\s+");
          if(words.length != pattern.length()) return false;
        for (int i = 0;i < words.length ;i++) {
            char c = pattern.charAt(i);
            if( (memo.containsKey(c) && !memo.get(c).equals(words[i]))
               || (memo2.containsKey(words[i]) && memo2.get(words[i]) != c
            ))return false;
            memo.put(c,words[i]);
            memo2.put(words[i],c);
        }
        return true;
    }
}
