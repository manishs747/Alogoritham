package Array;

public class NextGreaterNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      //  int arr [] = {4,5,2,25};
        int arr1 []  = {30,40,70,50,60,20};
    
        printNextGreater(arr1);
        
	}
	
	
	
	static void printNextGreater(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int max = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					max = arr[j];
					break;
				}
			}
			System.out.print(max + " ");
		}
	}
	
	static void printNextGreaterUsingStack(int arr[]){
		
	}

}
