package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

public class MaxSquare {


    public static void main(String[] args) {

        int arr[][] = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        Utility.print(arr);
        System.out.println(countGoodRectangles(arr));
    }


    public static int countGoodRectangles(int[][] rectangles) {
        int square = 0;
        for (int [] rec :rectangles) {
            int small = Math.min(rec[0],rec[1]);
            square = Math.max(square,small);
        }
        int result = 0;
        for (int [] rec :rectangles) {
            int small = Math.min(rec[0],rec[1]);
            if(small >= square){
                result++;
            }
        }

        return result;
    }
}
