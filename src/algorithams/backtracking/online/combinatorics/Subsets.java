package algorithams.backtracking.online.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 * https://www.educative.io/courses/grokking-coding-interview/introduction-to-subsets
 * https://www.youtube.com/watch?v=NA2Oj9xqaZQ&t=78s
 *
 */
public class Subsets {  //Order doesn't matter


    public static void main(String[] args) {

        int[] arr = {1, 2 , 3};//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsetsBackTrack(arr));
    }


    //***************************************************************BackTracking Solution ******************************************


    public static List<List<Integer>> subsetsBackTrack2(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        subsetsBackTrack2(nums,0,new ArrayList<>(),subsetList);
        return subsetList;
    }

    public static void subsetsBackTrack2(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
         if(index == nums.length) {
             result.add(new ArrayList<>(curr));
             return ;
         }
        subsetsBackTrack2(nums,index+1,curr,result);
        curr.add(nums[index]);
        subsetsBackTrack2(nums,index+1,curr,result);
        curr.remove(curr.size()-1);
    }



    //***************************************************************BackTracking Solution 2 ******************************************

    public static List<List<Integer>> subsetsBackTrack(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        subsetsBackTrack(nums, 0, new ArrayList<>(), subsetList);
        return subsetList;
    }

    private static void subsetsBackTrack(int[] nums, int index, ArrayList<Integer> curr, List<List<Integer>> subsetList) {
        subsetList.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            subsetsBackTrack(nums, i + 1, curr, subsetList);
            curr.remove(curr.size() - 1);
        }
    }


    //***************************************************************Cascading Solution ******************************************

    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        return subsetsRecursive(nums, 0);
    }

    public static List<List<Integer>> subsetsRecursive(int[] nums, int index) {
        List<List<Integer>> subsetList = new ArrayList<>();
        if (nums.length == index) {
            subsetList.add(new ArrayList<>());
            return subsetList;
        }
        List<List<Integer>> reminderList = subsetsRecursive(nums, index + 1);
        subsetList.addAll(reminderList);
        for (List<Integer> list : reminderList) {
            List<Integer> current = new ArrayList<>(list);
            current.add(nums[index]);
            subsetList.add(current);
        }
        return subsetList;
    }


    public static List<List<Integer>> subsetRecursive2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        subsetRecursive(nums,0,result);
        return result;
    }

    public static void subsetRecursive(int[] nums , int index,List<List<Integer>> lists ) {
        if(index >= nums.length)  return;
        List<List<Integer>> subset = new ArrayList<>();
        for (List<Integer> list : lists){
            List<Integer> current = new ArrayList<>(list);
            current.add(nums[index]);
            subset.add(current);
        }
        lists.addAll(subset);
        subsetRecursive(nums,index+1,lists);
    }

    /**************************************************ITERATIVE******************************************************************/


    public static List<List<Integer>> subsetsIterating1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(List.of(new ArrayList<>()));
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }

    public static List<List<Integer>> subsetsIterating2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(List.of(new ArrayList<>()));
        for (int num:nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> list : result){
                List<Integer> current = new ArrayList<>(list);
                current.add(num);
                temp.add(current);
            }
            result.addAll(temp);
        }
        return result;
    }
}

