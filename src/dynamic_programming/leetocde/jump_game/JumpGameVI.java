package dynamic_programming.leetocde.jump_game;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-vi/
 * https://federico-feresini.medium.com/jump-game-vi-algorithms-visualizations-a3df67dd30d9
 *
 */
public class JumpGameVI {


    public static void main(String[] args) {
        int [] nums = {1,-1,-2,4,-7,3};
        System.out.println(maxResult(nums,2));//7
    }


    public static int maxResult(int[] nums, int k) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0;i<nums.length;i++){
           for (int j = 1;j <= k  && i+j < nums.length ;j++){

           }
        }
        return dp[nums.length-1];
    }
}
