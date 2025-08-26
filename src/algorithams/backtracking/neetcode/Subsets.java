package algorithams.backtracking.neetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * https://neetcode.io/problems/subsets?list=neetcode150
 */
public class Subsets {

    public static void main(String[] args) {
         int [] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num:nums) {
            List<List<Integer>> tmpLists = new ArrayList<>(result);
            for (List<Integer>  tmpList: tmpLists) {
                List<Integer> tmp = new ArrayList<>(tmpList);
                tmp.add(num);
                result.add(tmp);
            }
        }
       return result;
    }


}
