package Array.matrix;

import Array.Utility;

//https://leetcode.com/problems/transpose-matrix/
public class Transpose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {-2,2,4};
	
		int [] result = sortedSquares(A);
		Utility.print(result);

	}
	
	
	public static int[] sortedSquares(int[] A) {
		int [] result = new int [A.length];
		int prev = Integer.MAX_VALUE;
		int i = 0;
		while(i < A.length-1) {
			int current = Math.abs(A[i]);
			if(Math.abs(prev) >= current && current < Math.abs(A[i+1])) {
				break;
			}
			prev = A[i];
			i++;
		}
		System.out.println("MIN:"+A[i]);
		int left = i-1;
		int right = i+1;
		result[0] = A[i]*A[i];
		int c = 1;
		while(left >= 0 && right < A.length) {
			if(Math.abs(A[left]) <= Math.abs(A[right])) {
				result[c] = A[left]*A[left];
				left--;
			}else {
				result[c] = A[right]* A[right];
				right++;
			}
			c++;
		}
	    while(left >= 0) {
	    	result[c] = A[left]*A[left];
			left--;
	    	c++;
	    }
		
	    while(right < A.length) {
	    	result[c] = A[right]* A[right];
			right++;
			c++;
		}
		return result;
	}
	
	
	public static  int[][] transpose(int[][] A) {
		int row = A.length;
		int col = A[0].length;
		int [][] result = new int [col][row];
		for (int i = 0; i < col; i++) {
			for(int j = 0; j < row; j++) {
			//	System.out.println("i:"+i+" j:"+j);
                result[i][j] =  A[j][i];
			}
		}
		return result;

	}

}
