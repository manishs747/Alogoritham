package algorithams.twopointer;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if(nums[i-1] == nums[i]) return true;
        return false;
    }


    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            if (!numSet.add(num)) return true;
        return false;
    }
}
