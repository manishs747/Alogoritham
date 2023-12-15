package data_structure.arrays.online.sum;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */


public class TwoSum2 {

    public static void main(String[] args) {
       int [] numbers = {2,6,7,11,15};
       int  target = 9;
       // Output: [1,3]
        ArrayUtils.print(twoSum(numbers,target));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0,j = numbers.length-1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) return new int[]{i+1, j+1};
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }


}
