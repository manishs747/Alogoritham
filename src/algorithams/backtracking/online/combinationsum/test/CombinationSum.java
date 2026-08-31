package algorithams.backtracking.online.combinationsum.test;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/combination-sum/description/
 */
public class CombinationSum {


    public static void main(String[] args) {
       // Input: candidates = [2,3,6,7], target = 7
       // Output: [[2,2,3],[7]]
        int [] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates,target));

    }


    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates,0,target,new ArrayList<>());
        return result;
    }

    public static void combinationSum(int[] candidates, int index, int target , List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(index >= candidates.length || target < 0) return;
        current.add(candidates[index]);
        combinationSum(candidates,index,target-candidates[index],current);
        current.remove(current.size()-1);
        combinationSum(candidates,index+1,target,current);
    }

    public static int makeChange(int amount,int index ,int [] coins){
        if(amount==0) return 1;
        if(amount < 0 || index >= coins.length) return 0;
        int ways = 0;
        ways += makeChange(amount-coins[index],index,coins);
        ways += makeChange(amount,index+1,coins);
        return ways;
    }


    public static void combinationSumOld(int[] candidates, int target , List<Integer> current) {
        if(target==0){
            result.add(new ArrayList<>(current));
            return ;
        }
        if (target < 0) return;
        for (int i=0; i<candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumOld(candidates, target - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}
