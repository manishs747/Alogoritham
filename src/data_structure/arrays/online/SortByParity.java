package data_structure.arrays.online;

import utils.ArrayUtils;

public class SortByParity {


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        ArrayUtils.print(sortArrayByParityII(arr));
    }


    public static int[] sortArrayByParityII(int[] nums) {
        for (int even = 0, odd = 1; even < nums.length && odd < nums.length ; even +=2,odd +=2) {
            while (even < nums.length && (nums[even] & 1) == 0)
                even += 2;
            while (odd < nums.length && (nums[odd] & 1) == 1)
                odd += 2;
            if (even < nums.length && odd < nums.length)
                swap(nums, even, odd);
        }
        return nums;
    }

    private static void swap(int[] nums, int even, int odd) {
        int tmp = nums[even];
        nums[even] = nums[odd];
        nums[odd] = tmp;
    }


    public static int[] sortArrayByParityII2pass(int[] nums) {
        sortArrayByParity1InPlace(nums);
        int evenIndex = 1, oddIndex = nums.length - 2;
        while (evenIndex < oddIndex) {
            swap(nums, evenIndex, oddIndex);
            evenIndex += 2;
            oddIndex -= 2;
        }
        return nums;
    }


    public static int[] sortArrayByParityIIExtraArray(int[] nums) {
        int result[] = new int[nums.length];
        int evenIndex = 0, oddIndex = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[evenIndex] = num;
                evenIndex += 2;
            } else {
                result[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return result;
    }


    /***********************************************even odd seperate ******************************************************************************* /
     /**
     * https://leetcode.com/problems/sort-array-by-parity/
     */


    public static int[] sortArrayByParity1InPlace(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                start++;
            } else {
                int tmp = nums[end];
                nums[end--] = nums[start];
                nums[start] = tmp;
            }
        }
        return nums;
    }


    public int[] sortArrayByParity1(int[] A) {
        int result[] = new int[A.length];
        int start = 0, end = A.length - 1;
        for (int val : A) {
            if (val % 2 == 0) {
                result[start++] = val;
            } else {
                result[end--] = val;
            }
        }
        return result;
    }


}
