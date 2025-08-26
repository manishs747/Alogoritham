package dynamic_programming.leetocde.houserobber;


import data_structure.strings.online.MakeTheStringGreat;

/**
 * https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HouseRobber {

    public static void main(String[] args) {
       int [] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//12
        int num1 [] = {1,2,3,1};//4
        System.out.println(robs(nums));
    }


    public static int robs(int[] nums) {
        return robs(nums,0, new Integer [nums.length]);
    }
    public static int robs(int[] nums, int index , Integer [] memo) {
        if(index >= nums.length) return 0;
        if(memo[index] != null) return memo[index];
        return  memo[index] =Math.max(nums[index] + robs(nums,index+2,memo),robs(nums,index+1,memo));
    }
}
