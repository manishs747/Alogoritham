package dynamic_programming.leetocde.subsequence;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int [] arr = { 1,3,5,4,7};
        System.out.println(findNumberOfLIS(arr));
    }


    public static int findNumberOfLIS(int[] nums) {
        return findNumberOfLISHelper(nums,0,new ArrayList<>());
    }


    public static int findNumberOfLISHelper(int[] nums, int index, List<Integer> selected) {
        if(index >= nums.length) return 0;
         int result = 0;
         if(selected.isEmpty() || selected.get(selected.size()-1) < nums[index]){
             List<Integer> newList = new ArrayList<>(selected);
             newList.add(nums[index]);
             result = 1+findNumberOfLISHelper(nums,index+1,newList);
         }
          result = Math.max(result,findNumberOfLISHelper(nums,index+1,selected));
        return result;
    }
}
