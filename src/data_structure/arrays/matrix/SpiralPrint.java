package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

import java.util.Scanner;



/*  
 * https://www.hackerrank.com/contests/coding-test-1-bits-hyderabad/challenges/spiral-matrix-1
    4
	1 2 3 4
	12 13 14 5
	11 16 15 6
	10 9 8 7
 */

public class SpiralPrint {
	
	
	
	
	public static void main(String[] args) {
		/* int arr[][] = { {1,  2,  3,  4,  5,  6},
			        {7,  8,  9,  10, 11, 12},
			        {13, 14, 15, 16, 17, 18}
			    };
		 System.out.println("Please ENTER Array");*/
		 
		int arr[][]=getInput();
		 Utility.print(arr);
		 spiralPrint(arr.length,arr.length, arr);
		 
	}


	private static int[][] getInput() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[][]  = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) { 
				arr[i][j] = in.nextInt();
			}
			System.out.println(" ");
		}
		in.close();
		return arr;
	}
	
	
	public static void spiralPrint(int R,int C,int arr[][]){
		int  r = 0, c = 0;//starting row and column

		while(r<R && c< C){

			for (int j = c; j < C ; j++) {
				System.out.print(arr[r][j] +" ");
			}
			r++;

			for (int j = r;j <R; j++) {
				System.out.print(arr[j][C-1]+" ");
			}
			C--;

			for (int j = C-1; j >= c; j--) {
				System.out.print(arr[R-1][j]+" ");
			}
			R--;

			for (int j = R-1; j >= r; j--) {
				System.out.print(arr[j][c]+" ");
			}
			c++;
		}
	}
	
	//also working
	private static void spiralPrint( int[][] arr) {
		int R = arr.length;
	    int C = arr[0].length;
	    int  r = 0, c = 0;//starting row and column
	    while(r<R && c< C){
	    	for (int i = c; i < C-c; i++) {
				System.out.print(arr[r][i]+" ");
			}
	    	r++;
	    	for (int i = r; i <= R-r; i++) {
	    		System.out.print(arr[i][C-c-1]+" ");
			}
	    	c++;
	    	for (int i = C-c-1; i >= c-1; i--) {
	    		System.out.print(arr[R-r][i]+" ");
			}
	    	for (int i = R-r-1; i > r-1; i--) {
	    		System.out.print(arr[i][c-1]+" ");
			}
	    }
	}

}
