package dynamic_programming.leetocde.sumCombination.unbounded;

public class CanSum {

    public static void main(String[] args) {
        int [] arr = {3,4};
        System.out.println(canSumTopDown(arr,10));
    }


    public static boolean canSumTopDown(int[] nums, int target) {
        Boolean [] memo = new Boolean[target];
        return canSumTopDownHelper(nums, target,memo);
    }

    private static boolean canSumTopDownHelper(int[] nums, int target,Boolean [] memo) {
        if(target < 0) return false;
        if(target == 0 ) return true;
        if(memo[target-1] != null)
            return memo[target-1];
        for (int n: nums)
            if(canSumTopDownHelper(nums, target -n,memo))
                return memo[target-1] = true;
        return memo[target-1] = false;
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
