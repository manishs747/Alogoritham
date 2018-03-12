package Array;
//https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,12,15,16,26,38};
	    int b[] = {2,13,14,17,30,45};
	    System.out.println(getMedianN(a, b));

	}
	
	
	public static float getMedianSingle(int arr[]){
		int n = arr.length;
		if(n == 0){
			return -1;
		}
	   if(n%2 == 0){
			return ((arr[n/2]+arr[n/2-1])/2);
		}
	   
		return arr[n/2];
	
	}
	
	
	
	public static float getMedianN(int [] a,int [] b){

		if(a.length == 0){
			return getMedianSingle(b);
		}
		if(b.length == 0){
			return getMedianSingle(b);
		}
		int n = (a.length + b.length )/2;
		boolean isEven = false;
		if(n%2 == 0){
			isEven = true;
		}
		int i = 0;  
		int j = 0; 
		int count;
		int m1 = -1, m2 = -1;

		for (count = 0; count <= n; count++)
		{

			if(i < a.length && j < b.length){
				if (a[i] < b[j])
				{   
					/* Store the prev median */
					m1 = m2;  
					m2 = a[i++];
				}
				else
				{
					/* Store the prev median */
					m1 = m2;  
					m2 = b[j++];
				}

			}else{ //done with one array

				if(i < a.length){
					m1 = m2;  
					m2 = a[i++];
				}else{
					m1 = m2;  
					m2 = b[j++];
				} 
			}

		}

		return isEven ? (m1 + m2)/2 : m2;
	}
	
	public static float findMedianUtil(int [] a,int [] b){
		if(a.length == 0){
			return getMedianSingle(b);
		}
		if(b.length == 0){
			return getMedianSingle(b);
		}
		
		
		
		
		
		return 0;
	}

}
