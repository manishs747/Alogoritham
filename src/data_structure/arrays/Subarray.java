package data_structure.arrays;

public class Subarray {


    /*
         https://leetcode.com/problems/maximum-subarray/
     */
    public static void main(String[] args) {

        int [] arr = {-5,-4,-1,-2,-3};
        System.out.println(maxSubArray(arr));
    }


    public static int maxSubArray(int[] nums) {
        int max_sum = nums[0], sum = nums[0];
        for (int i=1;i<nums.length ; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            if (sum > max_sum) {
                max_sum = sum;
            }
        }
        return max_sum;
    }

    /*
       https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
     */
    public int maximumSum(int[] arr) {


        return 0;
    }
}
