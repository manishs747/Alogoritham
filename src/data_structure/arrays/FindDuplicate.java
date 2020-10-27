package data_structure.arrays;

public class FindDuplicate {
	
	public static void main(String[] args) {
	System.out.println(getSingleOfDouble());	
	}
	
	
	
	
	//For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
	
	static void printRepeating(int arr[], int size) 
    {
		
		
		
		
		
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
