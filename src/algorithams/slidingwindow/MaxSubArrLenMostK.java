package algorithams.slidingwindow;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28
 */
public class MaxSubArrLenMostK {


    public static void main(String[] args) {
       int [] nums = {1,2,2,1,3};
       int k = 1; //3
       System.out.println(maxSubarrayLength(nums,k));
    }


    public static int maxSubarrayLength(int[] nums, int k) {
        int max = 1 , start = 0 ;
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int end = 0; end < nums.length; end++) {
            int cur = nums[end];
            countMap.put(cur,countMap.getOrDefault(cur,0)+1);
            while (countMap.get(cur) > k && start <= end){
                countMap.put(nums[start],countMap.get(nums[start])-1);
                start++;
            }
            max = Math.max(max,end-start+1);
        }
        return max;
    }



}
