package dynamic_programming.struckty;


import data_structure.strings.online.MakeTheStringGreat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * max path sum
 * https://leetcode.com/problems/minimum-path-sum/
 * https://www.structy.net/problems/max-path-sum
 */
public class PathSum {

    public static void main(String[] args) {
        List<List<Integer>> grid = List.of( //18
                List.of(1, 3, 12),
                List.of(5, 1, 1),
                List.of(3, 6, 1)
        );
        System.out.println(maxPathSum(grid));
    }

    public static int maxPathSum(List<List<Integer>> grid) {
        return maxPathSum(0,0,grid, new HashMap<>());
    }

    public static int maxPathSum(int r,int c, List<List<Integer>> grid, Map<String,Integer> memo) {
        if(r >= grid.size() || c >= grid.get(0).size()) return 0;
        if(r == grid.size()-1 && c == grid.get(0).size()-1) return grid.get(r).get(c);
        String key = r+"_"+c;
        if(memo.containsKey(key)) return memo.get(key);
        memo.put(key, grid.get(r).get(c) + Math.max(maxPathSum(r+1,c,grid,memo),maxPathSum(r,c+1,grid,memo)));
        return memo.get(key);
    }
}
