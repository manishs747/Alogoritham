package algorithams.backtracking.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * LeetCode 78 - Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * Time:  O(n * 2^n) — 2^n subsets, each copied in O(n)
 * Space: O(n * 2^n) — output storage; O(n) auxiliary recursion stack
 */
public class Subset {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // Expected: [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]
        System.out.println(subsets(nums));
    }

    /**
     * Entry point — pre-allocates result to 2^n to avoid ArrayList resizing.
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length); // pre-alloc 2^n
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }

    /**
     * Backtracking helper.
     *
     * @param nums   input array
     * @param res    accumulated results
     * @param path   current subset being built
     * @param index  start index for the next element to consider
     *
     * FIX: loop must start at `index`, NOT `path.size()`.
     *      Using path.size() causes duplicate elements when the same level
     *      is revisited after backtracking (e.g. path=[2] with index=2 would
     *      incorrectly re-include nums[1] producing [2,2]).
     */
    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int index) {
        res.add(new ArrayList<>(path));            // snapshot current subset (including empty)
        for (int i = index; i < nums.length; i++) { // ✅ start from index, not path.size()
            path.add(nums[i]);
            backtrack(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
