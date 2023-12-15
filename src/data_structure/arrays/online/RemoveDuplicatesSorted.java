package data_structure.arrays.online;

import utils.ArrayUtils;


/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicatesSorted {

    public static void main(String[] args) {
       int [] nums = {1,1,1};
        System.out.println(removeDuplicates2(nums));
        ArrayUtils.print(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int prevPointer = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[prevPointer] != nums[i])
              nums[++prevPointer] = nums[i];
        }
        return prevPointer+1;
    }


    /**
     * Given an integer array nums sorted in non-decreasing order,
     * remove some duplicates in-place such that each unique element appears at most twice.
     * The relative order of the elements should be kept the same.
     * Input: nums = [1,1,1,2,2,3]
     * Output: 5, nums = [1,1,2,2,3,_]
     */
    public static int removeDuplicates2(int[] nums) {
      int i = 2, j =2;
      while (j < nums.length){
          if (nums[j] == nums[i-1] && nums[j] == nums[i-2]){
              j++;
          }else{
              nums[i++] = nums[j++];
          }
      }
        return i;
    }


}
