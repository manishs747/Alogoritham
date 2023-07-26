package dynamic_programming.leetocde.sumCombination.unbounded;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {

    public static void main(String[] args) {

    }


    public int combinationSum4(int[] nums, int target) {
        int [] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return combinationSum4(nums,target, memo);
    }

    public static int combinationSum4(int[] nums, int target,int memo []) {
        if(target == 0) return 1;
        if (target < 0) return 0;
        if(memo[target] != -1)
            return memo[target];
        int ways = 0;
        for (int num:nums) {
            ways += combinationSum4(nums,target-num,memo);
        }
        return memo[target] = ways;
    }


}
