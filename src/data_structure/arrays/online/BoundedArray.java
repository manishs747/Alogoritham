package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
 */
public class BoundedArray {

    public static void main(String[] args) {
        //int[] nums = {3,2, 1, 4, 3};
        //int[] nums = {2,9,2,5,6};
        int [] nums = {73,55,36,5,55,14,9,7,72,52};
        int left = 32;
        int right = 62;
        System.out.println(numSubarrayBoundedMax3(nums, left, right));
    }

    public static int numSubarrayBoundedMaxN2(int[] nums, int left, int right) {
         int count = 0;
         for (int i=0;i < nums.length;i++){
             int max = nums[i];
             for (int j =i;j<nums.length;j++){
                 max = Math.max(max,nums[j]);
                if(max >= left && max <= right){
                    count++;
                }
             }
         }
        return count;
    }

    public static int numSubarrayBoundedMax1(int[] nums, int left, int right) {
        int res = 0, dp = 0,prev = -1;
        for (int i =0;i < nums.length;i++) {
            if(nums[i] < left ){
                res += dp;
            }
            if(nums[i] > right){
                dp = 0;
                prev = i;
            }
            if( left <= nums[i] && nums[i] <= right){
                dp = i - prev;
                res += dp;
            }
        }
        return res;
    }

    public static int numSubarrayBoundedMax2(int[] nums, int left, int right) {
        int res = 0, dp = 0,prev = -1;
        for (int i =0;i < nums.length;i++) {
            if(nums[i] > right){
                dp = 0;
                prev = i;
            }
            if( left <= nums[i] && nums[i] <= right){
                dp = i - prev;
            }
            res += dp;
        }
        return res;
    }


    public static int numSubarrayBoundedMax3(int[] nums, int LEFT, int RIGHT) {
        int result=0, l=-1, r=-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>RIGHT) l=i;
            if (nums[i]>=LEFT) r=i;
            result+=r-l;
        }
        return result;
    }

}
