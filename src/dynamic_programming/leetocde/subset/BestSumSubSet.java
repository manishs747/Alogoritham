package dynamic_programming.leetocde.subset;

import java.util.ArrayList;
import java.util.List;

public class BestSumSubSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};//true
        int target = 9;
        List<Integer>[] memo = new List[target + 1];
        System.out.println(bestSumBottomUp(arr, target));
    }

    /**
     * @returns list of number used to sum  with min count else null if not possible
     * m = target sum
     * n = array.length
     * non memo complexity
     * time : O(n^m*m)   space : O(m) = m^2
     * memo complexity
     * time : O(n*m^2)   space : m*m = m^2
     */
    public static List<Integer> bestSumTopDown(int[] nums, int target, List<Integer>[] memo) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        if (memo[target] != null)
            return memo[target];
        List<Integer> minList = null;
        for (int num : nums) {
            List<Integer> list = bestSumTopDown(nums, target - num, memo);
            if (list != null) {
                list = new ArrayList<>(list);
                if (null == minList || minList.size() > list.size() + 1) {
                    list.add(num);
                    minList = list;
                }
            }
        }
        return memo[target] = minList;
    }


    /**
     *
     */
    public static List<Integer> bestSumBottomUp(int[] nums, int target) {
        List<Integer>[] dp = new List[target + 1]; //array of list
        dp[0] = new ArrayList<>();
        for (int i = 0; i < target; i++) {
            if (dp[i] != null) {
                for (int num : nums) {
                    if (i + num <= target) {
                        List<Integer> current = new ArrayList<>(dp[i]);
                        if (dp[i + num] == null || dp[i + num].size() > current.size() + 1) {
                            current.add(num);
                            dp[i + num] = current;
                        }
                    }
                }
            }
        }
        return dp[target];
    }
}
