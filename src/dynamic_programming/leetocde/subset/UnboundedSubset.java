package dynamic_programming.leetocde.subset;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class UnboundedSubset {


    public static void main(String[] args) {
        int[] arr = {3, 4};//true
        List<Integer>[] memo = new List[12];
        System.out.println(canSumBottomUp(arr, 10));
        System.out.println(canSumBottomUpOptimised(arr, 10));
    }


    public static boolean canSumTopDown(int[] nums, int target, Boolean[] memo) {
        if (target == 0) return true;
        if (target < 0) return false;
        if (memo[target] != null)
            return memo[target];
        for (int num : nums) {
            if (canSumTopDown(nums, target - num, memo))
                return memo[target] = true;
        }
        return memo[target] = false;
    }


    public static boolean canSumBottomUp(int[] nums, int target) {
        boolean [] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 1;i<= target;i++){
            for (int num:nums) {
                if( i >= num && dp[i-num] ){
                    dp[i] = true;
                    break;
                }
            }
        }
        ArrayUtils.print(dp);
        return dp[target];
    }

    public static boolean canSumBottomUpOptimised(int[] nums, int target) {
        boolean [] dp = new boolean[target+1];
        dp[0] = true;
        for(int i = 0;i< target;i++){
            if(dp[i]){
                for (int num:nums) {
                    if( i + num  <= target){
                        dp[i+num] = true;
                    }
                }
            }
        }
        ArrayUtils.print(dp);
        return dp[target];
    }




















    /**
     *
     * @returns list of number user to sum else null if not possible
     *  m = target sum
     *  n = array.length
     *non memo complexity
     *time : O(n^m*m)   space : O(m) = m^2
     *memo complexity
     * time : O(n*m^2)   space : m*m = m^2
     */
    public static List<Integer> hasSumTopDown(int[] nums, int target, List<Integer>[] memo) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if (memo[target] != null)
            return memo[target];
        for (int num : nums) {
            List<Integer> list = hasSumTopDown(nums, target - num, memo);
            if (list != null){
                list.add(num);
                return memo[target] = list;
            }
        }
        return memo[target] = null;
    }




}
