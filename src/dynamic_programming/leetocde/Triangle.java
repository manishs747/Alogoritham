package dynamic_programming.leetocde;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {

    public static void main(String[] args) {
     // int   triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> grid = List.of( //11
                List.of(2),
                List.of(3,4),
                List.of(6,5,7),
                List.of(4,1,8,3)
        );
        System.out.println(minimumTotal2(grid));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle,0,0,new HashMap<>());
    }

    public static int minimumTotal(List<List<Integer>> triangle, int level, int index, Map<String,Integer> memo) {
        String key = level+"_"+index;
        if(memo.containsKey(key)) return memo.get(key);
        int result = triangle.get(level).get(index);
        if( level < triangle.size()-1)
            result += Math.min(minimumTotal(triangle,level+1,index,memo),minimumTotal(triangle,level+1,index+1,memo));
        memo.put(key,result);
        return result;
    }

    /*********************************************************************************************************************************************************/

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        Integer[][] memo = new Integer[numRows][numRows];
        return minimumTotal(triangle, 0, 0, memo);
    }

    public static int minimumTotal(List<List<Integer>> triangle, int row, int col, Integer[][] memo) {
        if (row == triangle.size() - 1) return triangle.get(row).get(col);
        if (memo[row][col] != null) return memo[row][col];
        int leftSum = minimumTotal(triangle, row + 1, col, memo);
        int rightSum = minimumTotal(triangle, row + 1, col + 1, memo);
         return memo[row][col] = triangle.get(row).get(col) + Math.min(leftSum, rightSum);
    }


}
