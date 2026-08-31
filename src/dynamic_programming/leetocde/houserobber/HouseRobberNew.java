package dynamic_programming.leetocde.houserobber;

import opennlp.tools.dictionary.Index;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberNew {


    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};
        //Output: 12
        System.out.println(rob(nums));
    }


    public static int rob(int[] nums) {
        return  rob(nums,0,new HashMap<>());
    }

    public static int rob(int[] nums, int index , Map<Integer,Integer> memo) {
        if(index >= nums.length) return 0;
        if(memo.containsKey(index)) return memo.get(index);
        int max1 = nums[index] + rob(nums,index+2,memo);
        int max2 = rob(nums,index+1,memo);
        memo.put(index,Math.max(max1,max2));
        return  memo.get(index);
    }



}
