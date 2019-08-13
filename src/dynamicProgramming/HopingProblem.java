package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*https://www.youtube.com/watch?v=kHWy5nEfRIQ&t=95s
 * https://www.interviewbit.com/problems/min-jumps-array/
 * https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 * 
 */


enum Index {
    GOOD, BAD, UNKNOWN
}

public class HopingProblem {
	
	static Index[] memo;

	public static void main(String[] args) {
		int [] arr1 = {2,3,1,1,4}; //true
		int [] arr3 = {0,1}; //false
		int []  arr2 = {3,2,1,0,4};//false
		int []  arr5 = {5,9,3,2,1,0,2,3,3,1,0,0}; //true
		int []  arr6 = {2,0,0}; //true
		int []  arr7 = {1,3,2}; //true



		System.out.println(canJumpDpTd(arr1));
		System.out.println(canJumpDpTd(arr2));
		System.out.println(canJumpDpTd(arr3));
	
		System.out.println(canJumpDpTd(arr5));
		System.out.println(canJumpDpTd(arr6));
		System.out.println(canJumpDpTd(arr7));

	}

	/*****************************************GREEDY LINEAR******************************************************************/	

	/*
	 * Time complexity : O(n)O(n). We are doing a single pass through the nums array, hence nn steps, where nn is the length of array nums.

      Space complexity : O(1)O(1). We are not using any extra memory.
	 */
	
	public static boolean canJump(int[] nums ) {
		int lastPostion = nums.length -1;
		for (int i = lastPostion; i >= 0; i--) {
			if (i + nums[i] >= lastPostion) {
				lastPostion = i;
			}
		}
		return lastPostion == 0;
	}

	
	/*****************************************recursve******************************************************************/	
	/*
	 * Time complexity : O(2^n)O(2 
n
 ). There are 2^n2 
n
  (upper bound) ways of jumping from the first position to the last, where nn is the length of array nums. For a complete proof, please refer to Appendix A.

Space complexity : O(n)O(n). Recursion requires additional memory for the stack frames. 
	 * 
	 */

	private static boolean canJumpRecursive(int[] nums ) {
		return canJumpRecursiveHelper(nums, 0);
	}

	private static boolean canJumpRecursiveHelper(int[] nums , int position) {
		if (position >= nums.length - 1) {
			return true;
		}
		int fartherMostJump = Math.min(position + nums[position], nums.length-1);
		for (int nextPosition = fartherMostJump; nextPosition > position; nextPosition--) {
			if(canJumpRecursiveHelper(nums, nextPosition)) {
				return true;
			}
		}
		return false;
	}

	/*****************************************Top Down  N2******************************************************************/	
	
	private static boolean canJumpDpTd(int[] nums ) {
		HashMap<Integer, Boolean> memo = new HashMap<Integer,Boolean>(nums.length);
		memo.put(nums.length-1, true);
		return canJumpDpHelperTD(nums, 0 , memo);
	}

	private static boolean canJumpDpHelperTD(int[] nums , int position ,Map<Integer,Boolean> memo) {
		if (memo.containsKey(position)) {
			return memo.get(position);
		}
		int fartherMostJump = Math.min(position + nums[position], nums.length-1);
		for (int nextPosition = position + 1; nextPosition <= fartherMostJump; nextPosition++) {
			if(canJumpDpHelperTD(nums, nextPosition,memo)) {
				memo.put(position, true);
				return true;
			}
		}
		memo.put(position, false);
		return false;
	}
	
/*****************************************LEET CODE   N2******************************************************************/	
	  public boolean canJumpleetCode(int[] nums) {
	         memo = new Index[nums.length];
	        for (int i = 0; i < memo.length; i++) {
	            memo[i] = Index.UNKNOWN;
	        }
	        memo[memo.length - 1] = Index.GOOD;
	        return canJumpFromPositionLeetCode(0, nums);
	    }
	
    public static boolean canJumpFromPositionLeetCode(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionLeetCode(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    /*****************************************LEET CODE  N2******************************************************************/	

	private static boolean canJumpHelperDpBu(int[] nums , int index , boolean [] memo) {
		System.out.println();
		boolean result = false;
		if(index >= nums.length-1) {
			return true;
		}
		if(memo[index] ) {
			return true;
		}
		for (int i = 0; i < nums[index] && i < nums.length-1; i++) {
			int newIndex = index+ nums[index]-i;
			result = canJumpHelperDpBu(nums,newIndex ,memo);
			//	System.err.println("Result with index"+newIndex);
			if (result ) {
				if (newIndex < nums.length ) {
					memo[newIndex] = true;
				}
				return result;
			}
		}
		if (index < nums.length ) {
			memo[index] = false;
		}
		return false;
	}

}
