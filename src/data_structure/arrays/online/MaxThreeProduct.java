package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.Arrays;

public class MaxThreeProduct {

    /*
       https://leetcode.com/problems/maximum-product-of-three-numbers/


       [-4,-3,-2,-1,60]   //720
       [1000,1000,1000]   1000000000
     */
    public static void main(String[] args) {
        int arr [] = {-10,-10,-10};
        System.out.println(maximumProducts(arr));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        ArrayUtils.print(nums);
        int max1 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int max2 = nums[0]*nums[1]*nums[nums.length-1];
        return Math.max(max1,max2);
    }


    public static int maximumProducts(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (min1 >= c) {
                min2 = min1;
                min1 = c;
            } else if (min2 >= c) {
                min2 = c;
            }
            if (c >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = c;
            } else if (c >= max2 ) {
                max3 = max2;
                max2 = c;
            } else if (c >= max3) {
                max3 = c;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

}
