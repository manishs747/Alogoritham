package data_structure.arrays.intervals;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SummaryRanges {

    public static void main(String[] args) {
       int []  nums = {0,1,2,4,5,7};//Output:["0->2","4->5","7"]
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
         List<String> output = new ArrayList<>();
         if(nums.length == 0) return output;
         int first = 0 , second = 0;
         while (second < nums.length){
             while (second+1 < nums.length && nums[second] +1 == nums[second+1]) second++;
             String list = (first == second) ? String.valueOf(nums[first]) : nums[first]+"->"+nums[second];
             output.add(list);
             first = ++second;
         }
        return output;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> output = new ArrayList<>();
        if(nums.length == 0) return output;
        for (int first = 0,second = 0;second < nums.length; first = ++second) {
            while (second+1 < nums.length && nums[second] +1 == nums[second+1]) second++;
            output.add((first == second) ? String.valueOf(nums[first]) : nums[first]+"->"+nums[second]);
        }
        return output;
    }

    public List<String> summaryRanges3(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            // Keep iterating until the next element is one more than the current element.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }
        return ranges;
    }


}
