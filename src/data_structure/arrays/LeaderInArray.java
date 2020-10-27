package data_structure.arrays;


/*
 https://www.geeksforgeeks.org/leaders-in-an-array/
 
  {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 * 
 * 
 * 
 */
public class LeaderInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =   {16, 17, 4, 3, 5, 2};
		int leader = -1;
		for (int i =  arr.length -1 ; i >= 0; i--) {
			int val = arr[i];
			if(val > leader){
				leader = val;
				System.out.println(val);
			}
		}

	}

}
