package dynamic_programming.leetocde.houserobber;


/**
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class HouseRobber2 {

    public static void main(String[] args) {
       int nums [] = {1,3,1,4,100};//
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max1 = rob(nums, 0, nums.length - 2, new Integer[nums.length]);
        int max2 = rob(nums, 1, nums.length - 1, new Integer[nums.length]);
        return Math.max(max1, max2);
}

    public static int rob(int[] nums, int start ,int end, Integer [] memo) {
        if(start > end) return 0;
        if(memo[start] != null) return memo[start];
        return  memo[start] =Math.max(nums[start] + rob(nums,start+2,end,memo),rob(nums,start+1,end,memo));
    }






    public static int rob2(int[] nums, int index , Integer [] memo , boolean first) {
        if(index >= nums.length || (first && index == nums.length-1)) return 0;
        if(index == 0) {
            return Math.max(nums[index] + rob2(nums,index+2,memo,true),rob2(nums,index+1,memo,false));
        }else{
            return Math.max(nums[index] + rob2(nums,index+2,memo,first),rob2(nums,index+1,memo,first));
        }
    }
}
