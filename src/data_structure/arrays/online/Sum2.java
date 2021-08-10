package data_structure.arrays.online;


import utils.ArrayUtils;

import java.util.*;

/**
 *
 */
public class Sum2 {


    public static void main(String[] args) {
          int [] arr = { 3,2,4};

        ArrayUtils.print(twoSumSort(arr,6));
    }


    /**
     * https://leetcode.com/problems/two-sum/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    /**
     * https://leetcode.com/problems/3sum/
     */
    public static int[] twoSumSort(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        Arrays.sort(nums);
        while (start<end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            }
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[2];
    }
}
