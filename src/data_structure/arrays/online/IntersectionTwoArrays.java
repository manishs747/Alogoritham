package data_structure.arrays.online;

import utils.ArrayUtils;

import java.util.*;

public class IntersectionTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4, 4, 9, 9}, nums2 = {9, 4, 9, 8, 4};
        ArrayUtils.print(intersect(nums1, nums2));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> inputSet = new HashSet<>();
        for (int num : nums1) {
            inputSet.add(num);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (inputSet.contains(num)) {
                resultSet.add(num);
            }
        }
        int arr[] = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            arr[i++] = num;
        }
        return arr;
    }

    //duplicate allowed
    //https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> inputMap = new HashMap<>();
        for (int num : nums1) {
            inputMap.put(num, inputMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (inputMap.containsKey(num) && inputMap.get(num) > 0) {
                result.add(num);
                inputMap.put(num, inputMap.get(num) - 1);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
