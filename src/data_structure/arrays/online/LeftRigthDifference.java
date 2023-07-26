package data_structure.arrays.online;

import utils.ArrayUtils;

public class LeftRigthDifference {

    public static void main(String[] args) {
       int [] nums = {10,4,8,3};
        ArrayUtils.print(leftRigthDifference(nums));
    }

    public static int[] leftRigthDifference(int[] nums) {
          int [] result = new int [nums.length];
          int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            result[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = Math.abs(result[i]-sum);
            sum += nums[i];
        }
          return result;
    }
}
