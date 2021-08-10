package dynamic_programming;


/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LargestIncreasingSubsequence {

    public static void main(String[] args) {
        int arr[] = {0,1,0,3,2,3};//4
        System.out.println(lengthOfLIS(arr));//4
    }


    public static int lengthOfLIS(int[] nums) {
       return lengthOfLIS(nums,0,-1);
    }

    public static int lengthOfLIS(int[] nums,int index,int max) {
        if(index == nums.length-1){
            return 1;
        }
        //int count = Math.max(1+lengthOfLIS(nums,index+1,));

        return 0;
    }




}
