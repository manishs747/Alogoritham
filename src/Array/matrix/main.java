package Array.matrix;

import java.util.Scanner;

import Array.Utility;

/*  
 * https://www.hackerrank.com/contests/coding-test-1-bits-hyderabad/challenges/spiral-matrix-1
    4
	1 2 3 4
	12 13 14 5
	11 16 15 6
	10 9 8 7
 */



public class main {
	
	
	public static void main(String[] args) {
		/* int arr[][] = { {1,  2,  3,  4,  5,  6},
			        {7,  8,  9,  10, 11, 12},
			        {13, 14, 15, 16, 17, 18}
			    };
		 System.out.println("Please ENTER Array");*/
		 
		int arr[][]=getInput();
		// Utility.print(arr);
		 
		 spiralPrint(arr);
		 
	}
	
		public static void spiralPrint(int arr[][]){
			int R = arr.length-1,C = arr.length-1;
			int r = 0,c = 0;
			while(r<R && c < C) {
				for ( int i = c  ; i <= C; i++) {
					System.out.print(arr[r][i]+" ");
				}
				r++;
				for (int j = r; j <= R; j++) {
					//System.out.println("I;"+j+" J:"+C);
					System.out.print(arr[j][C]+" ");
				}
				C--;
				for (int j = C ; j >= c; j--) {
					System.out.print(arr[R][j]+" ");
				}
				R--;
				for (int j = R; j >= r; j--) {
					System.out.print(arr[j][c]+" ");
				}
				c++;
			}
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

}
