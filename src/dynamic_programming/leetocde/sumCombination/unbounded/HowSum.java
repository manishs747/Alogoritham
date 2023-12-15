package dynamic_programming.leetocde.sumCombination.unbounded;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class HowSum {

    public static void main(String[] args) {
        int [] arr = { 5,3,4,7};
        int target = 7;
        System.out.println(combinationSum(arr,target,new HashMap<>()));
    }


    /**
     * m = target len ,n = arr.length
     * O(n^m*m)  // time complexity
     * space: O(m)
     * optimized:
     *TIME:  O(n*m*m)  extra m is for copying array
     *space: O(m*m=m2)  memo taking space : m keys and each list of size m
     */
    public static List<Integer> combinationSum(int[] candidates, int target, Map<Integer,List<Integer>> memo) {
        if(target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if(memo.containsKey(target)) return memo.get(target);
        for (int candidate:candidates) {
            List<Integer> reminderWay = combinationSum(candidates, target - candidate,memo);
            if(reminderWay != null){
                List<Integer> resultWay = new ArrayList(reminderWay);//new array is created as reference is passed
                resultWay.add(candidate);
                memo.put(target,resultWay);
                return resultWay;
            }
        }
        memo.put(target,null);
        return null;
    }
}
