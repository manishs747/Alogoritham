package data_structure.arrays.online.sum;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 */

public class Sum3 {

    public static void main(String[] args) {
        int arr[] = {-1,0,1,1,1,1,1,2,-1,-4};
        System.out.println(threeSumn3(arr));
    }

    public static List<List<Integer>> threeSumn3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int high = nums.length - 1,low = i+1,target = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while (low < high && nums[low] == nums[low+1]) { low++; }
                        while (low < high && nums[high] == nums[high - 1]) { high--; }
                    }
                    if (nums[low] + nums[high] > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }


    public static List<Integer[]> twoSumSort(int[] nums, int low, int target) {
        int high = nums.length - 1;
        List<Integer[]> list = new ArrayList<>();
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                list.add(new Integer[]{nums[low], nums[high]});
                while (low < high && nums[low] == nums[low+1]) { low++; }
                while (low < high && nums[high] == nums[high - 1]) { high--; }
            }
            if (nums[low] + nums[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        return result;
    }
}
