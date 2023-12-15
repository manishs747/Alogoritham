package dynamic_programming.leetocde.word;

import java.util.*;

public class AllConstruct {

    public static void main(String[] args) {
        String s = "abcdef";
        List<String> wordDict = Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c");//4
        System.out.println(allConstructTopDown(s, wordDict, new HashMap<>()));
       //  System.out.println(allConstructBottomUp(s, wordDict));
    }

    /**
     * @return returns the all possible combination of number of ways   to construct the word from dictionary
     * time = O(n*m *m)
     * space(m2)
     */
    public static List<List<String>> allConstructTopDown(String s, List<String> wordDict, Map<String, List<List<String>>> memo) {
        if (s.isEmpty()) return Arrays.asList(new ArrayList<>());
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<List<String>> list = allConstructTopDown(s.substring(word.length()), wordDict, memo);
                for (List<String> resultList : list) {
                    resultList = new ArrayList<>(resultList);
                    resultList.add(word);
                    result.add(resultList);
                }
            }
        }
        memo.put(s, result);
        return result;
    }


    public static List<List<String>> allConstructBottomUp(String s, List<String> wordDict) {
        List<List<String>>[] dp = new List[s.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = new ArrayList<>();
        dp[0] = Arrays.asList(new ArrayList<>());
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i);
            if (!dp[i].isEmpty()) {
                for (String word : wordDict) {
                    if (sub.startsWith(word)) {
                        for (List<String> list : dp[i]) {
                            ArrayList<String> resultList = new ArrayList<>(list);
                            resultList.add(word);
                            dp[i + word.length()].add(resultList);
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }


}
