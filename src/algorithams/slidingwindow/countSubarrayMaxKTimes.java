package algorithams.slidingwindow;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29
 */
public class countSubarrayMaxKTimes {


    public static void main(String[] args) {
      int nums [] = {1,3,2,3,3 };
      int k = 2;
      System.out.println(countSubarrays(nums,k));

    }


    public static long countSubarrays(int[] nums, int k) {
        int start = 0, end = 0, count = 0, n = nums.length;
        long result = 0;
        int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        while (end < n) {
            if (nums[end++] == max) count++;
            while (count == k) {
                result += n - end + 1;
                if (nums[start++] == max) count--;
            }
        }
        return result;
    }


    public static long countSubarrays2(int[] nums, int k) {
       int count = 0 , start = 0 , end = 0,END = nums.length;
        long result = 0;
        int max = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
       while (start <= end & end < END){
           while (end < END && count < k ){
               if(nums[end++] == max) count++;
           }
           while (start < end && count >= k){
               result += END - end +1;
               if(nums[start++] == max) count--;
           }
       }
       return result;
    }
}
