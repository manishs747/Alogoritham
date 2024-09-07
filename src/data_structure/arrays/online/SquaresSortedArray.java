package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.Arrays;

public class SquaresSortedArray {

    public static void main(String[] args) {
       int [] nums = {-4,-1,0,3,10};//Output: [0,1,9,16,100]
        ArrayUtils.print(sortedSquares(nums));
    }


    public static int[] sortedSquares(int[] nums) {
        int [] rnum = new int[nums.length];
        int left = 0 ,right = nums.length-1 , current =  right;
        while (left <= right)
            rnum[current--] = Math.abs(nums[left]) < Math.abs(nums[right]) ? nums[right]*nums[right--] : nums[left]*nums[left++];
        return rnum;
    }


    public static int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length ; i++)
            nums[i] *= nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
