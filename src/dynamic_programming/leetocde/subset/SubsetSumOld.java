package dynamic_programming.leetocde.subset;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 
 https://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * https://www.geeksforgeeks.org/partition-problem-dp-18/?ref=lbp
 *
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3jEPRo5PDvx
 * https://www.youtube.com/watch?v=3N47yKRDed0
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/
 *
 Partition problem is to determine whether a given set can be partitioned into two subsets such that
 * the sum of elements in both subsets is the same.
 *
	arr[] = {1, 5, 11, 5}
	Output: true
	The array can be partitioned as {1, 5, 5} and {11}

	arr[] = {1, 5, 3}
	Output: false
	The array cannot be partitioned into equal sum sets.
 * 
 */
public class SubsetSumOld {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};//true
        int[] arr2 = {1, 1, 3, 4, 7};//true
        int[] arr3 = {2, 3, 4, 6};//false
        System.out.println(canPartition(arr3));
        new HashMap<String, Boolean>();
    }


    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sequential().sum();
        if (nums.length == 0 || sum % 2 != 0) {
            return false;
        }
       // return canPartitionRecursiveTopDown(nums, sum / 2, nums.length - 1, new HashMap<>());
        Boolean[][] memo = new Boolean[nums.length][sum / 2 + 1];
        return canPartitionRecursiveTopDown(nums, sum / 2, nums.length - 1, memo);
    }

    private static boolean canPartitionRecursive(int[] num, int sum, int n) {
        if (sum == 0) {
            return true;
        } else if (n == 0 || sum < 0) {
            return false;
        }
        return canPartitionRecursive(num, sum - num[n], n - 1) || canPartitionRecursive(num, sum, n - 1);
    }


    private static boolean canPartitionRecursiveTopDown(int[] num, int sum, int n, Map<String, Boolean> memo) {
        if (sum == 0) {
            return true;
        } else if (n == 0 || sum < 0) {
            return false;
        }
        String key = n + "_" + sum;
        if (!memo.containsKey(key)) {
            memo.put(key, canPartitionRecursiveTopDown(num, sum - num[n], n - 1, memo) || canPartitionRecursiveTopDown(num, sum, n - 1, memo));
        }
        return memo.get(key);
    }

    private static boolean canPartitionRecursiveTopDown(int[] num, int sum, int n, Boolean[][]  memo) {
        if (sum == 0) {
            return true;
        } else if (n == 0 || sum < 0) {
            return false;
        }
        if (memo[n][sum] == null)  {
            memo[n][sum] = canPartitionRecursiveTopDown(num, sum - num[n], n - 1, memo) || canPartitionRecursiveTopDown(num, sum, n - 1, memo);
        }
        return memo[n][sum];
    }


    public boolean canPartitionBottomUp(int[] num) {
        int n = num.length;
        // find the total sum
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with same total
        if(sum % 2 != 0)
            return false;

        // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // populate the sum=0 column, as we can always have '0' sum without including any element
        for(int i=0; i < n; i++)
            dp[i][0] = true;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? true : false);
        }

        // process all subsets for all sums
        for(int i=1; i < n; i++) {
            for(int s=1; s <= sum; s++) {
                // if we can get the sum 's' without the number at index 'i'
                if(dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
                    dp[i][s] = dp[i-1][s-num[i]];
                }
            }
        }

        // the bottom-right corner will have our answer.
        return dp[n-1][sum];
    }


}
