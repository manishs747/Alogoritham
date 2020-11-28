package data_structure.arrays.online;


import java.util.Arrays;

/*
https://www.geeksforgeeks.org/split-array-two-equal-sum-subarrays/

 */
public class SplitEqualArray {


    public static void main(String[] args) {
       int [] nums = {1,5,11,5};
        canPartition(nums);
    }


    public static boolean canPartition(int[] nums) {
      int sum =  Arrays.stream(nums).sequential().sum();
      if(sum % 2 != 0){
          return false;
      }
      int half = sum/2;
      return false;
    }
}
