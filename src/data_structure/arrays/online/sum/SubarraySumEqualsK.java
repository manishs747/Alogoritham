package data_structure.arrays.online.sum;


import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
      int []  nums = {1,0,0};
      int k = 0;
      System.out.println(subarraySum(nums,k));
    }


    public static int subarraySum(int[] nums, int k) {
    int count = 0 , start = 0, end = 1 , sum = nums[start];
    while(start <= end){
       if(sum == k) count++;
       if(sum >= k){
           sum -= nums[start++];
       }else{
           if(end == nums.length)
               break;
           sum += nums[end];
           end++;
       }
    }

    return count;
    }


    public static int subarraySumPrefix(int[] nums, int k) {
        int sum = 0,count = 0;
        Set<Integer> prefixSumSet = new HashSet<>();
        prefixSumSet.add(0);
        for (int num:nums) {
            sum += num;
            prefixSumSet.add(sum);
            if(prefixSumSet.contains(sum - k)) count++;
        }
        return count;
    }


}
