package data_structure.arrays.online;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {

    //https://leetcode.com/problems/lucky-numbers-in-a-matrix/
    public static void main(String[] args) {


        int[][] matrix = {{3,7,8},
                {9,11,13},
                {15,16,17},
        };

        System.out.println(luckyNumbers(matrix));

    }


    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int [] minRow = getMinRow(matrix, row, col);
        for (int i = 0; i < col; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int j = 0; j < row; j++) {
               if(matrix[j][i] > max){
                   max = matrix[j][i];
                   maxIndex = j;
               }
            }
           if(minRow[maxIndex] == matrix[maxIndex][i]){
               result.add(minRow[maxIndex]);
           }
        }
        return result;
    }

    private static  int [] getMinRow(int[][] matrix, int row, int col) {
        int [] minRow = new int[row];
        for (int i = 0; i < row; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < col; j++) {
                min = Math.min(matrix[i][j],min);
            }
            minRow[i] = min;
        }
        return minRow;
    }
}
