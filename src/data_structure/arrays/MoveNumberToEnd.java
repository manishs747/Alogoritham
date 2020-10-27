package data_structure.arrays;

public class MoveNumberToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
	    // out arr[] = {1, 2, 4, 3, 5, 0, 0};
		System.out.println(pushNumberToEnd(arr, 0));
		
		moveToEnd(arr);
		Utility.print(arr);
	}


	public static void moveZeroes(int[] nums) {
		int zp = 0;
		for (int cp = 0; cp < nums.length; cp++) {
			int current = nums[cp];
			if (current != 0) {
				nums[zp++] = current;
			}
		}
		for (; zp < nums.length; zp++) {
			nums[zp] = 0;
		}
	}
	
	
	//move zero in front 
	  static void moveToEnd(int mPlusN[] ) 
	    {
		  int size = mPlusN.length;
	        int i, j = size - 1;
	        for (i = size - 1; i >= 0; i--) 
	        {
	            if (mPlusN[i] != 0) 
	            {
	                mPlusN[j] = mPlusN[i];
	                j--;
	            }
	        }
	    }
	
	
	
	public static int pushNumberToEnd(int arr[],int num){
		int count  = 0 ;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			if(current != num){
				arr[count++] = current;
			}
		}
		// Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
		int numberCount =  count;
        while (count < arr.length)
            arr[count++] = num;
        return numberCount;
	}

}