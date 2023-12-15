package data_structure.arrays.online.majority;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2}; //2
        System.out.println(majorityElement(nums));

    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length/2 +1; i++)
            if(nums[i] == nums[i+nums.length/2]) return nums[i];
        return -1;
    }
}
