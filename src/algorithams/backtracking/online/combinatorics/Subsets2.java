package algorithams.backtracking.online.combinatorics;


import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Subsets2 {

    public static void main(String[] args) {
       int [] nums = {1,2,2};
       System.out.println(subsetsWithDup(nums));
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetList = new ArrayList<>();
        subsetsWithDup(nums,0,new ArrayList<>(),subsetList);
        return new ArrayList<>(subsetList);
    }

    public static void subsetsWithDup(int[] nums,int index,List<Integer> current,List<List<Integer>> subsetList) {
      if (index == nums.length){
          subsetList.add(new ArrayList<>(current));
          return;
      }
      current.add(nums[index]);
      subsetsWithDup(nums,index+1,current,subsetList);
      current.remove(current.size()-1);
      while (index < nums.length-1 && nums[index] ==  nums[index+1])
          index++;
      subsetsWithDup(nums,index+1,current,subsetList);
    }




    /***************************************************************Using Set ***************************************************/
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> subsetList = new HashSet<>();
        subsetsWithDup1(nums,0,new ArrayList<>(),subsetList);
        return new ArrayList<>(subsetList);
    }

    public static void subsetsWithDup1(int[] nums,int index,List<Integer> current,Set<List<Integer>> subsetList) {
        subsetList.add(new ArrayList<>(current));
        for (int i = index; i < nums.length ; i++) {
            current.add(nums[i]);
            subsetsWithDup1(nums,i+1,current,subsetList);
            current.remove(current.size()-1);
        }
    }


}
