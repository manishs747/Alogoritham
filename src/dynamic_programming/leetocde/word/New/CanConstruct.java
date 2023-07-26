package dynamic_programming.leetocde.word.New;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CanConstruct {

    public static void main(String[] args) {
        String s = "purple";
        List<String> wordDict = Arrays.asList("purp", "p", "ur", "le", "purpl");//2
        System.out.println(countConstructBottomUp(s, wordDict));

    }


    public static int countConstructBottomUp(String s, List<String> wordDict) {
        if(s.isEmpty()) return 1;
        //if(memo.containsKey(s)) return memo.get(s);
        int result = 0;
        for(String word:wordDict){
            if(s.startsWith(word)){
               // memo.put(s,true);
               result += countConstructBottomUp(s.substring(word.length()),wordDict);
            }
        }
        //memo.put(s,false);
        return result;
    }
}
