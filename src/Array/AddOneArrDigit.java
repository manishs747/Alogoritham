package Array;




//https://www.geeksforgeeks.org/adding-one-to-number-represented-as-array-of-digits/
public class AddOneArrDigit {
	
	
	public static void main(String[] args) {
		int [] arr1 = {1,3,5};
		int [] arr2 = {1,9,9};
		int [] arr3 = {9,9,9};
		Utility.print(addOne(arr1));
		Utility.print(addOne(arr2));
		Utility.print(addOne(arr3));
	}
	
	
	
	
	public static int[] addOne(int[] arr) {
		int carry = 1;
		//int [] result = new int [arr.length];
		for (int i = arr.length-1; i >= 0; i--) {
			int sum = arr[i]+carry;
			if (sum == 10) {
				carry = 1;
				arr[i] = 0;
			} else {
				arr[i] = sum;
				carry = 0;
				break;
			}
		}
		
		if (carry == 1 ) {
			arr = new int[arr.length+1];
			arr[0] = 1;
		}
		return arr;
	}

}
