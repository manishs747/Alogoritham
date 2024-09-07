package algorithams.twopointer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> numSet = new HashMap<>();
        for (int i = 0;i < nums.length ; i++){
            if (numSet.containsKey(nums[i]) && Math.abs(numSet.get(nums[i]) - i ) <= k)
                return true;
            numSet.put(nums[i],i);
        }
        return false;
    }
}
