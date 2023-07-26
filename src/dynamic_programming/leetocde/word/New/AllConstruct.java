package dynamic_programming.leetocde.word.New;

import java.util.*;

public class AllConstruct {

    public static void main(String[] args) {
        String s = "abcdef";
        List<String> wordDict = Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c");//2
        System.out.println(allConstructTopDown(s, wordDict));
    }

    /**
     * @return returns the all possible combination of number of ways   to construct the word from dictionary
     * time = O(n*m *m)
     * space(m2)
     */
    public static List<List<String>> allConstructTopDown(String s, List<String> wordDict) {
        if(s.isEmpty()) return Arrays.asList(new ArrayList<>());
        List<List<String>> allWays = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<List<String>> childrenWays =  allConstructTopDown(s.substring(word.length()), wordDict);
                for (List<String> child :childrenWays) {
                    List<String> localList = new ArrayList<>(Arrays.asList(word));
                    localList.addAll(child);
                    allWays.add(localList);
                }
            }
        }
        return allWays;
    }
}
