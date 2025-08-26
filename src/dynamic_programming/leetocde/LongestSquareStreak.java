package dynamic_programming.leetocde;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-square-streak-in-an-array/?envType=daily-question&envId=2024-10-28
 */
public class LongestSquareStreak {

    public static void main(String[] args) {
       int [] nums = {2,3,5,6,7};// 2 3 4  6 8 16
       System.out.println(longestSquareStreak(nums));
    }


    public static int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        HashMap<Integer,Integer> memo = new HashMap<>();
        for (int i = nums.length-1;i >= 0 ;i--) {
            int num = nums[i];
            int streaklength = memo.getOrDefault(num*num,0)+1;
             memo.put(num,streaklength);
             max = Math.max(max,streaklength);
        }
        return  max < 2 ? -1 : max;
    }
}
