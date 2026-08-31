package Interview.careem;

import utils.ArrayUtils;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
       int []  nums = {3,2,4};
       int  target = 6;
        ArrayUtils.print(twoSum(nums,6));
    }




    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++){
            if(map.containsKey(target- nums[i])){
                return new int [] {i,map.get(target- nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }



}
