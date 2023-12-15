package dynamic_programming.leetocde.word;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "abcdef";
        List<String> wordDict = Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c");//4
        System.out.println(allConstructTopDown(s, wordDict));
    }

    private static List<List<String>> allConstructTopDown(String s, List<String> wordDict) {
        if (s.isEmpty()) return Arrays.asList(new ArrayList<>());
        List<List<String>> allWaysList = new ArrayList<>();
        for (String prefix:wordDict) {
            if(s.startsWith(prefix)){
                String suffix = s.substring(prefix.length());
                List<List<String>> remainingWays = allConstructTopDown(suffix,wordDict);
                for (List<String> remaingway: remainingWays) {
                    List<String> localList = new ArrayList<>(Arrays.asList(prefix));
                    localList.addAll(remaingway);
                    allWaysList.add(localList);
                }
            }
        }
        return allWaysList;
    }


}
