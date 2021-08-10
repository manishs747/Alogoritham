package data_structure.heap;

/*
 * 
 https://www.youtube.com/watch?v=B7hVxCmfPtM
 https://www.youtube.com/watch?v=qXdt1AHMB2o
 
 
 * 
 * 
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int[] getConcatenation(int[] nums) {
		int [] arr = new int[2*nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = arr[i+nums.length] = nums[i];
		}
        return arr;
	}

}
