package Array;

public class CheckIfSubArray {
	
	
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		int [] subarr = {4,5};
		System.out.println(isSubArray(arr, subarr));
	}
	
	
	public static int isSubArray(int [] arr,int [] subarr) {
		int result = -1;
		if(subarr.length == 0) {
			return 0;
		}
		int max = arr.length -subarr.length;
		if(arr.length == 0 || max < 0) {
			return result;
		}
		int first = subarr[0];
		for(int i =0 ;i <= max ;i++) {
			if (arr[i] != first) {
				while (++i < arr.length && arr[i] != first);
			}
			int j = i+1;
			int end = j + subarr.length - 1;
			for(int k = 1;k < subarr.length && arr[j] == subarr[k];k++,j++);
			if(j == end) {
				System.out.println(j);
				return i;
			}
		}
		return result;
	}

}
