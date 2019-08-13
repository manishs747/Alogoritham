package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/house-robber/
 * 
 * https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * 
 * 
 */


public class MaxAlternate {

	public static void main(String[] args) {

		int [] input = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //9
		int result = rob(input);
		System.out.println(result);


	}


	/*[1,2,3,1]   4
	 * 
	 * [2,7,9,3,1] 12
	 * 
	 * [2,1,3,1,2,4]  9
	 * 
	 * 
	 * Input : arr[] = {5, 5, 10, 100, 10, 5}
Output : 110

Input : arr[] = {1, 2, 3}
Output : 4

Input : arr[] = {1, 20, 3}
Output : 20
	 * 
	 */
	public static int rob(int[] nums) {
		int [] memo = new int [nums.length];
		Arrays.fill(memo,-1);
		return robTopDown(nums, nums.length - 1,memo);
	}
	
	static int robTopDown(int[] nums,int index ,int [] memo) {
		if(index < 0) {
			return 0;
		}
		if (index == 0) {
			return nums[0];
		}
		if(index == 1) {
			return Math.max(nums[0], nums[1]);
		}
		if(memo[index] == -1) {
			int include = nums[index]+robTopDown(nums, index-2,memo);
			int exclude = 	robTopDown(nums, index-1,memo);
			memo[index] = Math.max(include,exclude);
		}
		return memo[index];
	}
	
	


}
