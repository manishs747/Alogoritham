package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/?envType=daily-question&envId=2025-02-03
 */
public class LongestMonotonicSubarray {

    public static void main(String[] args) {

       int []  nums = {3,2,1};
        System.out.println(longestMonotonicSubarray(nums));

    }

    public static int longestMonotonicSubarray(int[] nums) {
       int maxCount = 1 , minCount = 1 , prevMax = 0 , prevMin = 0 , maxCCount = 0,minCCount = 0;
        for (int i = 1; i < nums.length ; i++) {
            minCCount++ ;
            maxCCount++;
            if(nums[i] <= nums[i-1]){
                maxCount = Math.max(maxCount,i-prevMax);
                prevMax = i;
                maxCCount = 0;
            }
            if(nums[i] >= nums[i-1]){
                minCount = Math.max(minCount,i-prevMin);
                prevMin = i;
                minCCount = 0;
            }
            maxCount = Math.max(maxCount,maxCCount);
            minCount = Math.max(minCount,minCCount);

        }
        return Math.max(maxCount,minCount);
    }
}
