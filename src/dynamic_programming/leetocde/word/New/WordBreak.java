package dynamic_programming.leetocde.word.New;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] args) {
        String word = "applepenapple";
        String [] wordDict = {"apple","pen"};
        System.out.println(wordBreak(word, Arrays.asList(wordDict)));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
       return wordBreakHelper(s,0,wordDict,new HashMap<>());
    }

    public  static boolean wordBreakHelper(String s, int index, List<String> wordDict, Map<Integer,Boolean> memo) {
        if(s.length() == index) return true;
        if(memo.containsKey(index)) return memo.get(index);
        for (String word:wordDict) {
            if (compare(s,index,word) && wordBreakHelper(s,index+word.length(),wordDict,memo)){
                memo.put(index,true);
                return true;
            }
        }
         memo.put(index,false);
         return false;
    }

    public static  boolean compare(String s ,int index , String dictWord){
        if (index+dictWord.length() > s.length()) return false;
        return s.substring(index,index+dictWord.length()).equals(dictWord);
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreakBottomUp(s,wordDict,new HashMap<>());
    }


    private static boolean wordBreakBottomUp(String s, List<String> wordDict , Map<String,Boolean> memo) {
        if(s.isEmpty()) return true;
        if(memo.containsKey(s)) return memo.get(s);
        for(String word:wordDict){
            if(s.startsWith(word) && wordBreakBottomUp(s.substring(word.length()),wordDict,memo)){
                memo.put(s,true);
                return true;
            }
        }
        memo.put(s,false);
        return false;
    }
}
