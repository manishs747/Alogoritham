package Array.matrix;


/*
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 * 
 * 1 2 3
   4 5 6
   9 8 9
   
   
   output 
 */
public class DiagonalDifference {
	
	
	
	static int diagonalDifference(int[][] arr) {
		int len = arr.length;
		int left = 0;
		int right = 0;
		for(int i=0;i<len;i++) {
			left = left + arr[i][i];
			right = right + arr[i][len-i];
		}
		return Math.abs(left - right);
    }
	

}
