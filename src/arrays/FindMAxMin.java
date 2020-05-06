package arrays;

public class FindMAxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr [] = {1,2,3,4,5,6};
		findMAxMin(arr);

	}
	
	public static void findMAxMin(int arr[]){
		int max = arr[0], min =  arr[0];
		for (int num : arr) {
			//checkforMax
			if(num > max){
				max = num;
			}//checks for min
			else if(num < min){
				min = num;
			}

		}
		System.out.println("MAx:"+max);
		System.out.println("MIN:"+min);
		
	}
	
	
	public static void reverse(int arr[]){
		
	}
	
	
	

}
