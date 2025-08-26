package dynamic_programming.leetocde.sumCombination.unbounded;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
 * https://www.structy.net/problems/sum-possible
 */
public class CanSum {

    public static void main(String[] args) {
        int [] arr = {3,4};
        System.out.println(sumPossible(15 , Arrays.asList(3,4)));
    }

    public static boolean sumPossible(int amount, List<Integer> numbers) {
       return sumPossible(amount,numbers,new Boolean[amount]);
    }

    public static boolean sumPossible(int amount, List<Integer> numbers , Boolean [] memo) {
       if(amount == 0) return true;
       if(amount < 0) return false;
       if(memo[amount-1] != null) return memo[amount-1];
       for (int num:numbers)
           if(sumPossible(amount-num,numbers))
               return memo[amount-1]=true;
        return memo[amount-1]=false;
    }



    private static boolean canSumBottomUp(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: it is always possible to make a sum of 0
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0 && dp[i - n]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[target];
    }


}
