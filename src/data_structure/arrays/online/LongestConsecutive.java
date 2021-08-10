package data_structure.arrays.online;


import utils.ArrayUtils;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int [] nums = {9,1,-3,2,4,8,3,-1,6,-2,-4,7};
        System.out.println(longestConsecutive2(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        ArrayUtils.print(nums);
        int prev = Integer.MIN_VALUE;
        int count = 0;
        int maxCount = 0;
        for(int i = 0;i < nums.length;i++){
            if(prev == nums[i]){
                continue;
            }
            if(prev+1 != nums[i]){
                maxCount = Math.max(maxCount,count);
                count = 0;
            }
            prev =nums[i];
            count++;
        }
        maxCount = Math.max(maxCount,count);
        return maxCount;
    }


    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int max = 0;
        for (int num:set) {
            if(!set.contains(num-1)){
                int count = 0;
                while(set.contains(num)){
                    num++;
                    count++;
                }
                max = Math.max(max,count);
            }
        }
        return max;
    }
}
