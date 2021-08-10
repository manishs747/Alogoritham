package dynamic_programming.leetocde.word;


import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreak2 {

    public static void main(String[] args) {
      /*  String s= "purple";
        List<String> wordDict = Arrays.asList("purp","p","ur","le","purpl");//2*/
        String s= "abcdef";
        List<String> wordDict = Arrays.asList("ab","abc","cd","def","abcd","ef","c");//2
        System.out.println(wordBreak(s,wordDict,new HashMap<>()));
    }

    /**
     * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where
     * each word is a valid dictionary word. Return all such possible sentences in any order.
     */

    public static List<String> wordBreak(String s, List<String> wordDict){
       return wordBreak(s,wordDict,new HashMap<>());
    }

    public static List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (s.isEmpty()) {
            ArrayList<String> emptyWordList = new ArrayList<>();
            emptyWordList.add("");
            return emptyWordList;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = wordBreak(s.substring(word.length()), wordDict, memo);
                for (String resultWord : list) {
                    resultWord = word + " " + resultWord;
                    result.add(resultWord.trim());
                }
            }
        }
        memo.put(s, result);
        return result;
    }



}
