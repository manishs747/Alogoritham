package data_structure.arrays.online;

public class MaxConsecutiveOne {



    public static void main(String[] args) {
        int arr [] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr,2));
    }


    public  static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int n :nums) {
            if(n == 0){
                maxCount = Math.max(maxCount,count);
                count = 0;
            }else{
                count++;
            }
        }
        maxCount = Math.max(maxCount,count);
        return maxCount;
    }


    /**
     * https://leetcode.com/problems/max-consecutive-ones-iii/
     */
    public static int longestOnes(int[] nums, int k) {
        int s = 0,f;
        for (f= 0;f<nums.length;f++){
            if(nums[f] == 0)
                k--;
            if(k < 0 && nums[s++] == 0)
                k++;
        }
        return f-s;
    }
}
