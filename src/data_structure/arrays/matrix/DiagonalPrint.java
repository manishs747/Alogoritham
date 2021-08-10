package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

public class DiagonalPrint {



    public static void main(String[] args) {
		int arr[][] = { {9, 8, 7},
				{6, 5, 4},
				{3, 2, 1}};
		Utility.print(arr);
		printDiagonalBottomUp(arr);

    }


    /*

     Given matrix is
        9	8	7
        6	5	4
        3	2	1


		 9
		 6 8
		 3 5 7
		 2 4
		 1
     */
    public static void printDiagonalBottomUp(int[][] arr) {
    	int R = arr.length;
    	int C = arr[0].length;


    }

	/*

	     Given matrix is
        9	8	7
        6	5	4
        3	2	1

       3
       6 2
       9 5 1
       8 4
       7
   */
    public static void printDiagonalBottomDown(int[][] arr) {

    }


}
