package algorithams.backtracking.subset;

import java.util.ArrayList;
import java.util.List;

public class AllSubSet {

    public static void main(String[] args) {

        int [] arr = {4,6,7,7};
        System.out.println(subsets(arr));

    }

   static List<List<Integer>>  subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

   static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
