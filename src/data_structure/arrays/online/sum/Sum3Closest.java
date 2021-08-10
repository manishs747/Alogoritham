package data_structure.arrays.online.sum;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Sum3Closest {


    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }


    public static int threeSumClosest(int[] nums, int target) {
        int minSum = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && minSum != target; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(minSum - target)) {
                    minSum = sum;
                }
                if (sum > target) end--;
                else start++;
            }
        }
        return minSum;
    }


    public static int threeSumClosest2(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
        }
        return target - diff;
    }


}
