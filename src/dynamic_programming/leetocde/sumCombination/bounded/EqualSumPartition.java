package dynamic_programming.leetocde.sumCombination.bounded;


import java.util.Arrays;

/***
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class EqualSumPartition {


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};//true
        int[] arr2 = {1, 1, 3, 4, 7};//true
        int[] arr3 = {2, 3, 4, 6};//false
        System.out.println(canPartition(arr2));
    }

    private static boolean canPartition(int[] num) {
        if (null == num || num.length == 0) {
            return false;
        }
        int sum = Arrays.stream(num).sum();
        if (sum % 2 != 0) {
            return false;
        }
        return subSetBottomUp(num, sum / 2);
    }

    private static boolean subSetSumTopDown(int[] num, int target) {
        Boolean[][] dp = new Boolean[num.length][target + 1];
        return subSetSum(num, 0, target, dp);
    }

    private static boolean subSetSum(int[] num, int index, int target, Boolean[][] dp) {
        if (num.length == 0 || index >= num.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        boolean result = false;
        if (num[index] <= target) {
            result = subSetSum(num, index + 1, target - num[index], dp);
        }
        return dp[index][target] = result || subSetSum(num, index + 1, target, dp);
    }


    /******************************************BottomUp***************************************************/


    public static boolean subSetBottomUp(int[] num, int target) {
        int n = num.length;
        boolean[][] dp = new boolean[n][target + 1];
        // populate the sum=0 column, as we can always have '0' sum without including any element
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int i = 1; i < target; i++) {
            dp[0][i] = num[0] == i ? true : false;
        }
        for (int i = 1; i < n; i++) {
            for (int s = 1; s < target + 1; s++) {
                if (dp[i - 1][s]) { // if we can get the sum  without the number at index 'i'
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= num[i]) {// else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i - 1][s - num[i]];
                }
            }
        }
        return dp[n - 1][target];
    }



    public boolean canPartitionLT(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        return subSetBottomUpON(nums,sum/2);
    }

    public static boolean subSetBottomUpON(int[] num, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < target; i++) {
            dp[i] = num[0] == i ? true : false;
        }
        for (int i = 1; i < num.length; i++) {
            for (int s = target; s > 0; s--) {
                if (!dp[s] && s >= num[i]) {
                    dp[s] = dp[s - num[i]];
                }
            }
        }
        return dp[target];
    }


    /*************Fast Solution*********0ms   *
     */

    public boolean canPartitionFS(int[] nums) {
        int sum= 0;
        for (int i=0; i<nums.length; i++){
            sum+= nums[i];
        }
        if (sum%2!=0) return false;
        sum/=2; //target sum

        // boolean[][] dp= new boolean[nums.length+1][sum+1];
        boolean[] dp= new boolean[sum+1];

        //whether a subset of nums[0..n] for some n can give us the target sum
        return dfs(nums, sum, 0, 0, dp);

    }

    //whether a subset of nums[0..idx] can give us target
    //sum is partial sum constructed so far
    public boolean dfs(int[] nums, int target, int sum, int idx, boolean[] dp){
        if (idx>= nums.length) return false;
        if (sum+ nums[idx]== target) return true;
        //if not the target sum and haven't seen the sum before
        //include nums[idx] in dfs sum
        if (sum+ nums[idx]<= target && !dp[sum+ nums[idx]]){
            dp[sum+ nums[idx]]= true;
            if (dfs(nums, target, sum+ nums[idx], idx+1, dp)) return true;
        }
        //ignore nums[idx]
        if (dfs(nums, target, sum, idx+1, dp)) return true;

        return false;
    }


}
