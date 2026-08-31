package algorithams.backtracking.subset;


import java.util.*;

/**
 * https://leetcode.com/problems/non-decreasing-subsequences/description/
 */
public class NonDecreasingSubsequences {

    public static void main(String[] args) {

         int [] nums = {4,6,7,7};
        //Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        System.out.print(findSubsequences(nums));
    }



    /**
     * Method 1 — Optimized: uses a per-level visited Set instead of a global HashSet of lists.
     *
     * Why the old approach was worse:
     *   - Stored every candidate in a HashSet<List<Integer>> which hashes the entire list on each add/contains — O(n) per op.
     *   - Collected back to List via stream — unnecessary allocation.
     *
     * This approach deduplicates at the source: if the same value was already branched on at this
     * recursion level (same `start`), skip it. This is O(201) per level (values -100..100), never
     * hashes whole lists, and requires no post-processing.
     *
     * Time:  O(n * 2^n) | Space: O(n) auxiliary stack + output
     */
    static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }
        Set<Integer> usedAtThisLevel = new HashSet<>();          // track values used at this depth
        for (int i = start; i < nums.length; i++) {
            if (usedAtThisLevel.contains(nums[i])) continue;    // skip duplicate branch
            if (temp.isEmpty() || temp.get(temp.size() - 1) <= nums[i]) {
                usedAtThisLevel.add(nums[i]);
                temp.add(nums[i]);
                backtrack(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);                   // backtrack
            }
        }
    }


    /**
     * Method 2 — same per-level visited Set strategy, uses LinkedList for O(1) peekLast/removeLast.
     * Slightly more expressive but identical in complexity to Method 1.
     * LinkedList is preferred here over ArrayList when peekLast() and removeLast() are called often.
     */
    public static List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new LinkedList<>(), 0, nums, res);
        return res;
    }

    private static void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));        // snapshot as ArrayList (cheaper to iterate later)
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (used.contains(nums[i])) continue;
            if (list.isEmpty() || nums[i] >= list.peekLast()) {
                used.add(nums[i]);
                list.addLast(nums[i]);             // O(1) for LinkedList
                helper(list, i + 1, nums, res);
                list.removeLast();                 // O(1) backtrack — clearer than remove(size-1)
            }
        }
    }



}






