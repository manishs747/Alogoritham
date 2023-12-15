package data_structure.arrays.online.sum;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
       int [] nums = {3,2,4};
       int target = 6;
        ArrayUtils.print(twoSum(nums, target));//1,2
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length ; i++)
            memo.put(nums[i],i);
        for (int i = 0; i < nums.length ; i++){
            if(memo.containsKey(target-nums[i]) && memo.get(target-nums[i]) != i){
                return new int[]{i,memo.get(target-nums[i])};
            }
        }
        return null;
    }
}
