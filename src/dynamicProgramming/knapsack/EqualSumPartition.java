package dynamicProgramming.knapsack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.educative.io/collection/page/5668639101419520/5633779737559040/5752754626625536
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * 
 * 
 */

public class EqualSumPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {61,96,15,73,64,57,7,25,52,68,59,53,72,6,22,76,12,8,29,99,1,77,57,39,95,51,44,61,67,35,70,96,46,91,51,38,33,80,45,68,20,9,6,74,4,89,10,58,95,38,85,62,13,23,2,5,73,45,17,3,62,64,65,50,21,30,36,60,43,57,25,63,47,72,35,94,79,88,2,57,60,32,96,66,90,5,48,74,45,88,24,3,38,80,50,45,83,66,74,91};
		//int nums [] = {1, 5, 11, 5};
		System.out.println("canPartition:"+canPartition(nums));

	}
	
	/*
	 * [1, 5, 11, 5]  true
	 * 
	 * [1, 2, 3, 5]  false
	 * 	
	 * 
	 * 
	 */
	
	 public static boolean canPartition(int[] nums) {
	        int sum = 0;
	    for (int i = 0; i < nums.length; i++)
	      sum += nums[i];

	    // if 'sum' is a an odd number, we can't have two subsets with equal sum
	    if (sum % 2 != 0)
	      return false;

	    Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
	    return canPartitionRecursive(dp, nums, sum / 2, 0);
	    }
	    
	     private static boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
	    // base check
	    if (sum == 0)
	      return true;

	    if (num.length == 0 || currentIndex >= num.length)
	      return false;

	    // if we have not already processed a similar problem
	    if (dp[currentIndex][sum] == null) {
	      // recursive call after choosing the number at the currentIndex
	      // if the number at currentIndex exceeds the sum, we shouldn't process this
	      if (num[currentIndex] <= sum) {
	        if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
	          dp[currentIndex][sum] = true;
	          return true;
	        }
	      }

	      // recursive call after excluding the number at the currentIndex
	      dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
	    }

	    return dp[currentIndex][sum];
	  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***********************MY SOL ***********************************/
	 public static boolean canPartitionOld(int[] nums) {
		 int sum  = getSum(nums);
		 if(sum % 2 != 0) {
			 System.out.println("Sum is ODD");
			 return false;
		 }
		 Map<String,Boolean> memo = new HashMap<>();
	     return isPossible(nums,sum/2,nums.length -1,memo);
	 }
	 
	 public static boolean isPossible(int[] nums,int val,int index,  Map<String,Boolean> memo) {
		 if (val == 0) {
			 return true;
		 }
		 if(index < 0 || val < 0) {
			 return false;
		 }
		
		 String key = index+"_"+val;
	     if(!memo.containsKey(key)) {
	    	 boolean exclude = isPossible(nums, val, index-1,memo);
			 boolean include = isPossible(nums, val-nums[index], index-1,memo);
			// System.out.println("INDEX:"+index+" exclude:"+exclude+" include"+include+ " VAL:"+val); 
			 memo.put(key, exclude || include);
	     }
		 return memo.get(key);
	 }
	 
	 
	 public static int getSum(int[] nums) {
		 int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		 return sum;
	 }
	 
	 
	
	


}
