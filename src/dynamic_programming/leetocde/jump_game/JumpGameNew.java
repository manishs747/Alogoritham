package dynamic_programming.leetocde.jump_game;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGameNew {

    public static void main(String[] args) {
       int [] arr =  {2,3,1,1,4};//true
        System.out.println(canJumpGreedy(arr));

    }

    /***************************************************Dynmaci Programing Top Down*************/
    public static boolean canJumpGreedy(int[] nums) {
        int count = 0;
        for (int i = nums.length-2; i >= 0 ; i--)
            count = count < nums[i] ? 0:count+1;
        return count == 0;
    }

    /***************************************************Dynmaci Programing Top Down*************/

    public static boolean canJump(int[] nums) {
        return canJump(nums,0,new Boolean  [nums.length]);
    }

    public static boolean canJump(int[] nums, int index, Boolean[] memo) {
            if(index == nums.length-1) return true;
            if(memo[index] != null) return memo[index-1];
            for (int i = 1; i <= nums[index] && i < nums.length ; i++) {
              if(canJump(nums,index+i,memo))
                  return memo[index] = true;
            }
        return memo[index] = false;
    }



}
