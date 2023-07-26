package dynamic_programming.leetocde.sumCombination.unbounded;


import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 * Combination-Sum-IV
 */
public class HowSumAll {

    public static void main(String[] args) {
        int [] candidates = {5,3,4,7};
        int targwt = 7;
        System.out.println(combinationSum(candidates,targwt));
    }



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSumHelper(candidates, target,new HashMap<>());
    }

    private static List<List<Integer>> combinationSumHelper(int[] candidates, int target, Map<Integer, List<List<Integer>>> memo) {
        if(target == 0){
            List<List<Integer>>  emptyList = new ArrayList<>();
            emptyList.add(new ArrayList<>());
            return emptyList;
        }
        if(target < 0) return null;
        if(memo.containsKey(target)) return memo.get(target);
        List<List<Integer>> result = new ArrayList<>();
        for (int candidate: candidates) {
            List<List<Integer>> childrens = combinationSumHelper(candidates, target - candidate,memo);
            if(childrens != null){
                for (List<Integer> child :childrens) {
                   List<Integer> localList = new ArrayList<>(Arrays.asList(candidate));
                    localList.addAll(child);
                    result.add(localList);
                }
            }
        }
        memo.put(target,result);
        return result;
    }

/********************************Other way of solving couting each coin****************************************************************/
//similar to coin change problem
    public static List<List<Integer>> combinationSum2(int[] candidates, int money, int index, Map<String, List<List<Integer>>> memo) {
        if (money == 0) return Arrays.asList(new ArrayList<>());
        if (index >= candidates.length) return new ArrayList<>();
        // String key = money + "_" + index;
        // if (memo.containsKey(key)) return memo.get(key);
        List<List<Integer>> resultWays = new ArrayList<>();
        int coinCount = 0;
        while (coinCount * candidates[index] <= money) {
            List<List<Integer>> reminderWays = combinationSum2(candidates, money - coinCount * candidates[index], index + 1, memo);
            if (!reminderWays.isEmpty()) {
                for (List<Integer> list : reminderWays) {
                    for (int i = 0; i < coinCount; i++) list.add(candidates[index]);
                    resultWays.add(new ArrayList<>(list));
                }
            }
            coinCount++;
        }
        // memo.put(key, resultWays);
        return resultWays;
    }


}
