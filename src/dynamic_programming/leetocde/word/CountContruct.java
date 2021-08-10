package dynamic_programming.leetocde.word;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CountContruct {


    public static void main(String[] args) {
        String s = "purple";
        List<String> wordDict = Arrays.asList("purp", "p", "ur", "le", "purpl");//2
        System.out.println(countConstructBottomUp(s, wordDict));
    }


    /**
     * @return returns the count of number of ways   to construct the word from dictionary
     * time = O(n*m *m)
     * space(m)
     */
    public static int countConstructTopDown(String s, List<String> wordDict, Map<String, Integer> memo) {
        if (s.isEmpty()) {
            return 1;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int totalWays = 0;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                totalWays += countConstructTopDown(s.substring(word.length()), wordDict, memo);
            }
        }
        memo.put(s, totalWays);
        return totalWays;
    }


    /**
     * @return returns the count of number of ways   to construct the word from dictionary
     * time = O(n*m *m)
     * space(m)
     *
     * good solution
     */
    public static int countConstructBottomUp(String s, List<String> wordDict) {
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (memo[i] != 0) {
                String subStr = s.substring(i);
                for (String word : wordDict) {
                    if (subStr.startsWith(word)) {
                        memo[i + word.length()] += memo[i];//important line  mistake people add only 1
                    }
                }
            }
        }
        return memo[s.length()];
    }
}
