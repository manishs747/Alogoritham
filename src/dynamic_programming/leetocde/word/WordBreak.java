package dynamic_programming.leetocde.word;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

    public static void main(String[] args) {
    /*   String s= "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");//true*/
        //  System.out.println(wordBreak(s,wordDict,new HashMap<>()));
        String s = "purple";
        List<String> wordDict = Arrays.asList("purp", "p", "ur", "le", "purpl");//2
        System.out.println(wordBreakTopDown(s, wordDict));
    }


    /**
     * @return true or false depending upon its possible to form the word from dictionary
     * <p>time = O(n^m *m)
     *      * space(m2)
     * <p>
     * time = O(n*m *m)
     * space(m2)
     */
    private static boolean wordBreakTopDown(String s, List<String> wordDict , Map<String,Boolean> memo) {
        if(s.isEmpty()) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(String word:wordDict){
            if(s.startsWith(word) && wordBreakTopDown(s.substring(word.length()),wordDict,memo)){
                memo.put(s,true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }


    /**
     * @return true or false depending upon its possible to form the word from dictionary
     * time = O(n*m *m)
     * space(m)

     * beautiful solution
     */
    public static boolean wordBreakTopDown(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (memo[i]) {
                String subStr = s.substring(i);
                for (String word : wordDict) {
                    if (subStr.startsWith(word)) {
                        memo[i + word.length()] = true;
                    }
                }
            }
        }
        return memo[s.length()];
    }
}
