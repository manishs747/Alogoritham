package dynamic_programming.leetocde;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPathSum {
    public static void main(String[] args) {

      // int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int [][] matrix = {{-19,57},{-40,-5}};
      //  int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};//13
       System.out.println(minFallingPathSum(matrix));//13
    }



    public static int minFallingPathSum(int[][] matrix) {
        int minPath = Integer.MAX_VALUE;
        Map<String,Integer> memo = new HashMap<>();
        for (int i=0; i < matrix[0].length;i++)
            minPath = Math.min(minPath,minFallingPathSum(matrix,0,i,memo));
        return minPath;
    }

    public static int minFallingPathSum(int[][] matrix,int row,int index, Map<String,Integer> memo) {
        if(matrix[row].length <= index || index < 0) return Integer.MAX_VALUE;
        int minPath = matrix[row][index];
        if(matrix.length-1 == row) return minPath;
        String key = row+"_"+index;
        if(memo.containsKey(key)) return memo.get(key);
        int first = minFallingPathSum(matrix,row+1,index-1,memo);
        int second = minFallingPathSum(matrix,row+1,index,memo);
        int third = minFallingPathSum(matrix,row+1,index+1,memo);
        minPath += Math.min(first,Math.min(third,second));
        memo.put(key,minPath);
        return minPath;
    }


}
