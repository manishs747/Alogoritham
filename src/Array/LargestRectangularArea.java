package Array;

import java.util.Scanner;

//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//https://www.hackerrank.com/challenges/largest-rectangle/problem
//https://www.sigmainfy.com/blog/leetcode-largest-rectangle-in-histogram.html
/*
 * 
 * input
 * 5
  1 2 3 4 5    
  output 9
  7
  6 2 5 4 5 1 6
  output 12
 * 
 * 
 */
public class LargestRectangularArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] arr = getInput();
		// Utility.print(arr);
		  System.out.println(getLargestAreaBruteForce(arr));
	}

	private static int[] getInput() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] arr = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		return arr;
	}
	
	public static int getLargestAreaBruteForce(int[] arr) {
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int height = arr[i];
			int totalbloack = getLeftBlock(arr, i, height)
					+ getRightBlock(arr, i, height);
			int area = height * totalbloack;
			System.out.println("For " + height + " leftBlock :"
					+ getLeftBlock(arr, i, height) + " rightBlock:"
					+ getRightBlock(arr, i, height) + " area = " + area);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	// include current
	private static int getLeftBlock(int[] arr, int current, int height) {
		int block = 0;
		for (int j = current; j >= 0; j--) {
			if (arr[j] >= height) {
				block = block + 1;
			} else {
				break;
			}
		}
		return block;
	}

	private static int getRightBlock(int[] arr, int current, int height) {
		int block = 0;
		for (int j = current + 1; j < arr.length; j++) {
			if (arr[j] >= height) {
				block = block + 1;
			} else {
				break;
			}
		}
		return block;
	}
	

}
