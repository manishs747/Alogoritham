package data_structure.arrays;

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
		 int [] arr = { 6 ,2 ,5 ,4, 5 ,1 ,6};
		 System.out.println(largestRectangleArea(arr));
	}


	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int totalled = getLeftBlock(heights, i, height) + getRightBlock(heights, i, height)+1;
			int area = height * totalled;
			System.out.println("For " + height + " leftBlock :" + getLeftBlock(heights, i, height) + " rightBlock:" + getRightBlock(heights, i, height) + " area = " + area);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
	}

	private static int getLeftBlock(int[] arr, int current, int height) {
		int block = 0;
		for (int j = current-1; j >= 0; j--) {
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
