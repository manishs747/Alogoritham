package Interview.wayfair;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums [] = {2,7,11,5};
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int key = Math.abs(nums[i] - target) ;
            if(map.containsKey(key)){
              return new int[]{i,map.get(key)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
