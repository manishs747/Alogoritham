package Array.matrix;

import java.util.ArrayList;

import Array.Utility;

/*
 * Rotate the image by 90 degrees (clockwise)
 * You need to do this in place
 * 
 * input 
   1   2   3   4
   5   6   7   8
   9  10  11  12
  13  14  15  16
  
  13   9   5   1
  14  10   6   2
  15  11   7   3
  16  12   8   4
   
   
   [
    [3, 1],
    [4, 2]
]
 * 
 */


public class RotateMatrix {
	public static void main(String[] args) {
		int [][] arr =
		      { {1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};
		Utility.print(arr);
		rotateClockWise90(arr);
		Utility.print(arr);
	}
	
	
	public static void rotateClockWise90(int [][] arr) {
		int n = arr.length;
		for (int layer = 0;layer < n/2;layer++) {
			int first = layer;
			int last = n-layer-1;
			for (int i = first; i < last; i++) {
				int offset = i-first;
				//save top
				int top = arr[first][i];
				//left top
				arr[first][i] = arr[last-offset][first];
				//bottom left 
				arr[last-offset][first] = arr[last][last-offset];
				//bootom right 
				arr[last][last-offset] = arr[i][last];
				//right top 
				arr[i][last] = top;
			}
		}
	}
	
	//good
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		for (int layer = 0;layer < n/2;layer++) {
			int first = layer;
			int last = n-layer-1;
			for (int i = first; i < last; i++) {
				int offset = i-first;
				//save top
				int top = a.get(first).get(i);
				//left top
				a.get(first).set(i,  a.get(last-offset).get(first));
				//bottom left 
				a.get(last-offset).set(first, a.get(last).get(last-offset));
				//bootom right 
				a.get(last).set(last-offset, a.get(i).get(last));
				//right top 
				a.get(i).set(last,top);
			}
		}

	}
	 
	

}
