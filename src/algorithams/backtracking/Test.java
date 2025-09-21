package algorithams.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {




    public static void main(String[] args) {
       String digits = "23";

    }



    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i= 0;i < nums.length;i++) {
            map.put(nums[i],i);
        }
        for (int i= 0;i < nums.length;i++) {
           if( map.containsKey(Math.abs(target-nums[i]))){
               return new int[]{i,map.get(Math.abs(target-nums[i]))};
           }
        }
        return null;
    }








}


