package Array;

public class FindDuplicate {
	
	public static void main(String[] args) {
	System.out.println(getSingleOfDouble());	
	}
	
	
	
	//Find the element that appears once
		//output should be 2
		public static int getSingleOfDouble(){
			int arr[] = {12, 12,  1, 1, 2, 3, 3};
			int n=arr[0];
			for (int i = 1; i < arr.length; i++) {
			 n = n ^ arr[i];
			}
			return n;
		}
	//Find the element that appears once
	//output should be 2
	public static int getSingle(){
		int arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		
		
		return 0;
	}

}
