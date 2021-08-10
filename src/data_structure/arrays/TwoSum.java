package data_structure.arrays;

import utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        ArrayUtils.print(twoSumSortedPointer(arr, 9));

    }


    /**
     * https://leetcode.com/problems/two-sum/
     */
    public static int[] twoSumNonSorted(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                int[] result = {map.get(complement), i};
                return result;
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }


    public static int[] twoSumSorted(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                int[] result = {map.get(complement) + 1, i + 1};
                return result;
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    public static int[] twoSumSortedPointer(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
