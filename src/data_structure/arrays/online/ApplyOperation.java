package data_structure.arrays.online;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/apply-operations-to-an-array/?envType=daily-question&envId=2025-03-01
 */
public class ApplyOperation {


    public static void main(String[] args) {
       int [] arr =  {0,1};
       // Output: [1,4,2,0,0,0]
        ArrayUtils.print(applyOperations(arr));
    }
    public static int[] applyOperations(int[] nums) {
        int nz  = 0 , i;
        for ( i = 0; i < nums.length-1 ; i++) {
              if(nums[i] == nums[i+1]){
                  nums[i] *= 2;
                  nums[i+1] = 0;
              }
            if(nums[i] != 0)
                swap(nums,nz++,i);
        }
        if(nums[i] != 0)
            swap(nums,nz,i);
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a]= nums[b];
        nums[b] = tmp;
    }


}
