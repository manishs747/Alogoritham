package dynamic_programming.leetocde.sumCombination.unbounded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        int [] arr = { 5,3,4,7};
        int target = 7;
        System.out.println(bestSum(arr,target,new HashMap<>()));
    }


    /**
     * m = target len ,n = arr.length
     * O(n^m*m)  // time complexity
     * space: O(m)
     * optimized:
     *TIME:  O(n*m*m)  extra m is for copying array
     *space: O(m*m=m2)  memo taking space : m keys and each list of size m
     */
    public static List<Integer> bestSum(int[] candidates, int target, Map<Integer,List<Integer>> memo) {
        if(target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if(memo.containsKey(target)) return memo.get(target);
        List<Integer> bestWays = null;
        for (int candidate : candidates) {
            List<Integer> reminderWay = bestSum(candidates, target - candidate,memo);
            if(reminderWay != null){
                List<Integer> resultWay = new ArrayList(reminderWay);
                resultWay.add(candidate);
                if(bestWays == null || reminderWay.size() <  bestWays.size())
                    bestWays =resultWay;
            }
        }
        memo.put(target,bestWays);
        return bestWays;
    }






























}
