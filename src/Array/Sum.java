package Array;

import java.util.HashMap;
import java.util.Map;

import utils.ArrayUtils;

public class Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3,2,4};
		ArrayUtils.print(twoSum(nums , 6));
		

	}
	
	
	 /*https://leetcode.com/problems/two-sum/
	  * 
	  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
	  * 
	  * 
	  */
	public static int[] twoSum(int[] nums, int target) {
		int [] arr = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length ; i++) {
			map.put(nums[i], i);
		}
		//System.out.println(map);
		for(int i = 0; i < nums.length ; i++) {
			//System.out.println( nums[i]);
			if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
				//System.out.println("GOT IT");
				//System.out.println(target - nums[i]);
				arr[0] = i;
				arr[1] = map.get(target - nums[i]);
				return arr;		  
			}
		}
		return arr;
	}

}
