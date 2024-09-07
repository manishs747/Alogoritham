package dynamic_programming.leetocde.word.New;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    public static void main(String[] args) {
        String word = "advaithavyaanadvaith";
        String [] wordDict = {"advaith","avyaan"};
        System.out.println(wordBreak(word, Arrays.asList(wordDict)));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
       return wordBreakHelper(s,wordDict,new HashMap<>());
    }

    public  static boolean wordBreakHelper(String s, List<String> wordDict, Map<String,Boolean> memo) {
          if(s.isEmpty()) return true;
          if(memo.containsKey(s)) return memo.get(s);
          for (String word:wordDict)
            if(s.startsWith(word) && wordBreakHelper(s.substring(word.length()),wordDict,memo) ){
                memo.put(s,true);
                return true;
            }
        memo.put(s,false);
        return false;
    }

}
