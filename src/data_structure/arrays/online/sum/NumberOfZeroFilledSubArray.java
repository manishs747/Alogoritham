package data_structure.arrays.online.sum;


/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
 */
public class NumberOfZeroFilledSubArray {

    public static void main(String[] args) {
       int [] nums = {2,10,2019};
        System.out.println(zeroFilledSubarray(nums));
    }


    public static long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                int j = i+1;
                while (j < nums.length && nums[j] == 0) j++;
                sum += getSummation(j-i);
                i =  j;
            }
        }
        return sum;
    }

    public static  long getSummation(long n){
        return n*(n+1)/2;
    }
}
