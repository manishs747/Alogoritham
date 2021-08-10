package data_structure.arrays.online;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class MinPairSum {
    public static void main(String[] args) {
        int [] arr = {3,5,4,2,4,6};
        System.out.println(minPairSum(arr));
    }


    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[0] + nums[len-1];
        for (int i = 1; i <nums.length/2 ; i++) {
            max = Math.max(max,nums[i] + nums[len-1-i]);
        }
        return max;
    }
}
