package algorithams.backtracking.neetcode.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * LeetCode 39 — Combination Sum
 *
 * Given an array of distinct candidates and a target, return all unique combinations
 * that sum to target. The same candidate may be used unlimited times.
 *
 * Time:  O(n ^ (target/min + 1)) — branching factor n, max depth = target/min_candidate
 * Space: O(target/min)           — max recursion depth; O(n * 2^n) for output
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        // Expected: [[2,2,3],[7]]
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sort enables early pruning (break when candidate > remaining)
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Backtracking helper.
     *
     * Key rule: pass `i` (not `i+1`) to the recursive call so the same
     * candidate can be reused in the next step.
     *
     * Early pruning: if candidates[i] > remaining, all further candidates
     * (sorted) will also exceed remaining — break immediately.
     *
     * @param candidates sorted input array
     * @param remaining  how much more we still need to sum to
     * @param start      index to start from (avoids counting duplicate combos)
     * @param path       current combination being built
     * @param result     accumulated valid combinations
     */
    private static void backtrack(int[] candidates, int remaining, int start,
                                  List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path)); // found a valid combination
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break; // ✅ early pruning — sorted array
            path.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, path, result); // i not i+1 → reuse allowed
            path.remove(path.size() - 1); // backtrack
        }
    }
}
