package algorithams.twopointer.nsum;

import com.sun.source.tree.CaseTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public static void main(String[] args) {
       // Input:
        int [] nums = {2,7,11,15};
       int target = 9;
       // Output: [0,1]
        System.out.println(twoSum(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(target-num)){
               return new int[]{i,map.get(target-num)};
            }
            map.put(num,i);
        }
        return null;
    }

}
