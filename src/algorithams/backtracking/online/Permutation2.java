package algorithams.backtracking.online;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutation2 {

    public static void main(String[] args) {
        int num[] = {1, 1, 3};
        System.out.println(permuteUnique(num));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        permute(nums, 0, result);
        return result.stream().collect(Collectors.toList());
    }


    public static void permute(int[] nums, int l, Set<List<Integer>> result) {
        if (l == nums.length - 1) {
            List<Integer> curr = new ArrayList<>();
            for (int i : nums) curr.add(i);
            result.add(curr);
            return;
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, l, i);
            permute(nums, l + 1, result);
            swap(nums, l, i);
        }
    }

    public static void swap(int[] nums, int i, int r) {
        if (i == r) return;
        int tmp = nums[i];
        nums[i] = nums[r];
        nums[r] = tmp;
    }


}
