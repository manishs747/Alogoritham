package algorithams.twopointer;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/description/?envType=daily-question&envId=2025-03-03
 */
public class PartionArrayPivot {


    public static void main(String[] args) {
        int [] nums = {9,12,5,10,14,3,10}; //9,5,3,10,10,12,14]
        int pivot = 10;
        ArrayUtils.print(pivotArray(nums,pivot));
    }


    public static int[] pivotArray(int[] nums, int pivot) {
        int [] result = new int[nums.length];
        int s = 0, e = nums.length-1;
        for (int i = 0; i < nums.length ; i++) {
            int start = nums[i] , end = nums[nums.length-i-1];
            if(start < pivot)
                result[s++] = start;
            if(end > pivot)
                result[e--] = end;
        }
        while (s <= e)
            result[s++] = pivot;
        return result;
    }
}
