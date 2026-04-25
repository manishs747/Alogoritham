package algorithams.backtracking.online.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class subsetnew {

    public static void main(String[] args) {
        int[] arr = {1, 2 , 3};//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        subsetsBackTrack(nums,0,new ArrayList<>());
        return result;
    }


    public static void subsetsBackTrack(int[] nums,int index,List<Integer> list){
        result.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            subsetsBackTrack(nums,i+1,list);
            list.removeLast();
        }

    }






}
