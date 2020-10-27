package data_structure.arrays.online;

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int []  nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> ma = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (ma.containsKey(nums[i]) && (i - ma.get(nums[i]) <= k)) return true;
            ma.put(nums[i],i);
        }
        return false;
    }


    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }



    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }


}
