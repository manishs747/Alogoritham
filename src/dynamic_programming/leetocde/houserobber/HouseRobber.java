package dynamic_programming.leetocde.houserobber;


import data_structure.strings.online.MakeTheStringGreat;

/**
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HouseRobber {

    public static void main(String[] args) {
       int [] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//12
        int num [] = {1,2,3,1};//4
        System.out.println(robNew(nums));
    }

    public static int robNew(int[] nums) {
        return robNew(nums,0,new Integer[nums.length+1]);
    }

    public static int robNew(int[] nums, int index , Integer [] memo ) {
      if(index >= nums.length) return 0;
      if(memo[index] != null) return memo[index];
      int max = nums[index] + robNew(nums,index+2,memo);
      if(index + 1 < nums.length)
          max = Math.max(max,nums[index+1] + robNew(nums,index+3,memo)) ;
      return memo[index] = max;
    }


    public static int rob(int[] nums) {
        return rob(nums,0, new Integer [nums.length+1]);
    }
    public static int rob(int[] nums, int index , Integer [] memo) {
        if(index >= nums.length) return 0;
        if(memo[index] != null) return memo[index];
        return  memo[index] =Math.max(nums[index] + rob(nums,index+2,memo),rob(nums,index+1,memo));
    }
}
