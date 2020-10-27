package data_structure.arrays;

import java.util.Arrays;

public class Arrcpy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arr1[] = { -1, 1, 2, 3, 4, 5 };
		   int arr2[] = { 0, 10, 20, 30, 40, 50 };
		    
		   // copies an array from the specified source array
		   //System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		   System.arraycopy(arr1, 0, arr2, 0, 3);
		   System.out.print("array2 = ");
		   System.out.print(arr2[0] + " ");
		   System.out.print(arr2[1] + " ");
		   System.out.print(arr2[2] + " ");
		   System.out.print(arr2[3] + " ");
		   System.out.print(arr2[4] + " ");
		   
		   
		// copying array arr1 to arr2 with newlength as 5
		   int[] arr3 = Arrays.copyOf(arr1, 7);
		   }

	

}
