package company.google;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/?envType=company&envId=google&favoriteSlug=google-all
 */
public class TwoSum {

    public static void main(String[] args) {
       int [] nums = {2,7,11,15};
       int target = 9;
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(target-cur)) {
                return new int[]{i, map.get(target-cur)};
            }
            map.put(cur, i);
        }
        return null;
    }
}
