package data_structure.arrays.online;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {

    public static void main(String[] args) {
       int [] nums = {1,2,3,4,5,6,7};//[5,6,7,1,2,3,4]
        int k = 4;
        rotate(nums,k);
        ArrayUtils.print(nums);
    }

    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }


    public static void reverse(int [] nums,int start,int end){
      while (start < end){
          int tmp = nums[start];
          nums[start++] = nums[end];
          nums[end--] = tmp;
      }
    }


    public static void rotate2(int[] nums, int k) {
        int rc = nums.length/k;
        for (int i = 0; i < k ; i++) {
            int count = 0, prev = nums[i], next = i;
            while (count < rc){
                next = (next+k)%nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                count++;
            }
        }
    }


}
