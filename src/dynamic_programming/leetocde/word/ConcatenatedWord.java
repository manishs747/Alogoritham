package dynamic_programming.leetocde.word;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/concatenated-words/
 */
public class ConcatenatedWord {


    public static void main(String[] args) {
      String [] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
       System.out.println(findAllConcatenatedWordsInADict(words));

        //System.out.println(wordBreak("catsdogcats",Arrays.asList("cat", "cats", "dog",  "rat"),new HashMap<>()));
    }


    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();
        for (String word : words) {
            List<String> filteredWord = Arrays.asList(words).stream().filter(line -> word.length() > line.length()).collect(Collectors.toList());
            boolean res = wordBreak(word, filteredWord, memo);
            if (res) result.add(word);
        }
        return result;
    }

    public static boolean wordBreak(String wd, List<String> wordDict, Map<String,Boolean> memo) {
        if(wd.isEmpty()){
            return true;
        }
      /*  if(memo.containsKey(wd)){
            return memo.get(wd);
        }*/
       // System.out.println(wd);
        for (String word:wordDict) {
            if(wd.startsWith(word) ){
                if (wordBreak(wd.substring(word.length()),wordDict,memo)){
                    memo.put(wd,true);
                    return true;
                }
            }
        }
        //memo.put(wd,false);
        return false;
    }
}
