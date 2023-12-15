package data_structure.arrays.online;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int nums[] = {-1,1,0,-3,3};
        ArrayUtils.print(productExceptSelf(nums));
    }

    public static int[] productExceptSelf(int[] nums) {
           int zeroCount = 0 , multiplcation = 1;
        for (int num :nums) {
            if(num == 0 ){
                if(zeroCount == 0){
                    zeroCount = 1;
                    continue;
                }else {
                     multiplcation = 0;
                     break;
                }
            }
            multiplcation *= num;
        }
        for (int i = 0; i < nums.length ; i++)
           nums[i] =  nums[i] == 0 ? multiplcation : zeroCount == 0? multiplcation/nums[i]:0;

        return nums;
    }
}
