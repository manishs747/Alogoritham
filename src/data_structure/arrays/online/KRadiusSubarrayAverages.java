package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
           int nums[] = {7,4,3,9,1,8,5,2,6};
        ArrayUtils.print(getAverages(nums,3));
    }


    public static int[] getAverages(int[] nums, int k) {
        int [] rest = new int[nums.length];
        int windowSize= 2*k+1;
        Arrays.fill(rest,-1);
        if(windowSize > nums.length) return rest;
        long sum = 0;
        for (int i = 0; i <windowSize ; i++) sum += nums[i];
        for (int i = k; i < nums.length-k ; i++) {
            rest[i] = (int) (sum/windowSize);
            if( i+k+1 < nums.length){
                sum = sum -nums[i-k] + nums[i+k+1];
            }
        }
        return rest;
    }
}
