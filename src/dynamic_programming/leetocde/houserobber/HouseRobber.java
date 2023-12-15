package dynamic_programming.leetocde.houserobber;

public class HouseRobber {

    public static void main(String[] args) {
       int [] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//12
        System.out.println(rob(nums));
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
