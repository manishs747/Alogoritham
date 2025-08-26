package algorithams.backtracking.online.combinatorics;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 3, k = 2;
        //Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

        System.out.println(combine(n,k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> subsetList = new ArrayList<>();
        combine(n,k,1,new ArrayList<>(),subsetList);
        return subsetList;
    }

    public static void combine(int n, int k ,int index, List<Integer> current,List<List<Integer>> subsetList) {
         if(current.size() == k){
             subsetList.add(new ArrayList<>(current));
             return; //imp
         }

        for (int i = index; i <= n ; i++) {
            current.add(i);
            combine(n,k,i+1,current,subsetList);
            current.remove(current.size()-1);
        }
    }


}
