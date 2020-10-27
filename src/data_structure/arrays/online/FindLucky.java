package data_structure.arrays.online;


import data_structure.arrays.Utility;

import java.util.*;

/*
https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */
public class FindLucky {

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};
         Utility.print(replaceElements(nums));
       // System.out.println(findLucky(nums));
    }

    public static int findLucky(int[] arr) {
        int result = -1;
        Map<Integer, Integer> treemap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for (int num : arr) {
            if (treemap.containsKey(num)) {
                treemap.put(num, treemap.get(num) + 1);
            } else {
                treemap.put(num, 1);
            }
        }
        for (int key : treemap.keySet()) {
            if (key == treemap.get(key)) {
                return key;
            }
        }
        return result;
    }



    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list =  new ArrayList<>();
        for (int i=0;i<nums.length;i += 2) {
            int f = nums[i];
            int v = nums[i+1];
            for (;f>0;f--){
                list.add(v);
            }
        }
      //  return list.stream().mapToInt(Integer::intValue).toArray();
        return list.parallelStream().mapToInt(Integer::intValue).toArray();
    }

    /*
    https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
       Input: arr = [17,18,5,4,6,1]
       Output: [18,6,6,6,1,-1]
     */
    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = max;
            max = Math.max(max, current);
        }
        return arr;
    }

}
