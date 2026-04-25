package algorithams.backtracking.online;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
       int [] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        int maxCount = 1, currentCount = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] == nums[i-1]){
                continue;
            }
             if(nums[i] == nums[i-1] + 1){
                currentCount++;
            }else {
                maxCount = Math.max(currentCount, maxCount);
                currentCount = 1;
            }
        }
        return Math.max(currentCount, maxCount);
    }
}
