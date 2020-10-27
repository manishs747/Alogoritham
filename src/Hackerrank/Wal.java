package hackerrank;

import java.util.Scanner;

public class Wal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "2519372893" ;
		String max = s;
		System.out.println(findMaximumNumNew(s, 6));
		
		/*
		 * 
		
		
		  5
		  3 1 2 4 5
		  3 2 4 1 5
		 
		 * 
		 */
	
		Scanner in = new Scanner(System.in);
		String n = in.next();//lenght of array
		int k = in.nextInt();
		System.out.println(findMaximumNumNew(n, k));
		/*int [] first = new int[n];
		int [] second  = new int[n];
		for (int i = 0; i < n; i++) {
			first[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			second[i] = in.nextInt();
		}
       System.out.println(findCompatibilityDifference(first, second));*/
	}
	
	
	static String findMaximumNumNew(String s, int k)
	{
	    // return if no swaps left
	    if(k == 0)
	        return s;
	 
	    int n = s.length();
	    StringBuilder number = new StringBuilder(s);
	    
	    for (int i = 1; i < n; i++)
	    {
	    	//System.out.println("K:"+k);
	    	  int index = findMax(number,i,k);
	    	//  System.out.println("Index:"+ index);
	    	  while(index >= i && k > -1){
	    		  swap(number,index,index-1);
	    		  k--;
	    		  index--;
	    	  }
	    	  System.out.println("K-:"+k+ " i : "+i );
	    	if(k == 0)  {
	    		break;
	    	}
	      
	    }
	    
	    return number.toString();
	}
	
	private static int findMax(StringBuilder number,int start, int k) {
	
		int maxIndex = start;
		for (int i = start+1; i <start+ k; i++) {
			if(number.charAt(maxIndex) < number.charAt(i)){
				maxIndex = i;
			}
			
		}
	
		return maxIndex;
	}


	
	
	public static void swap(StringBuilder number , int i ,int j){
	   char temp = number.charAt(i);
	   number.setCharAt(i, number.charAt(j));
	   number.setCharAt(j, temp);
	}
	
	
	
	
	/*
	
	 for (int i = 0; i < n - 1; i++)
	    {
	      
	        // and compare it with all digits after it
	        for (int j = i + 1; j < n; j++)
	        {
	            // if digit at position i is less than digit
	            // at position j, swap it and check for maximum
	            // number so far and recurse for remaining swaps
	            if (str[i] < str[j])
	            {
	                // swap str[i] with str[j]
	                swap(str[i], str[j]);
	 
	                // If current num is more than maximum so far
	                if (str.compare(max) > 0)
	                    max = str;
	 
	                // recurse of the other k - 1 swaps
	                findMaximumNum(str, k - 1, max);
	 
	                // backtrack
	                swap(str[i], str[j]);
	            }
	        }
	    }
	*/
	
	/*
	
	void maximizeArray(int * arr, int len, int swaps)
	{
	    
	   
		int max_index = -1, max = -std::numeric_limits<int32_t>::max();;
		     
		for(int j = 0; (j < len ) && (swaps > 0) ; ++j)
		{
		    max_index = findMaxIndex(arr,j,j+swaps);
	        
	        if(j != max_index)
	        {
	            int temp = arr[j];
	            arr[j] = arr[max_index];
	            arr[max_index] = temp;
	        
	        }
	    
	        swaps = swaps - (abs(max_index - j));
	                    
		}
		
	}*/
	/*
	int findMaxIndex(int* arr,int start, int end)
	{
		int max_index = start;
		for(int curr = start; curr <= min(n-1,end); curr++)
		{
		if(arr[curr] > arr[max_index])
		{
			max_index = curr;
		}
	}
		return max_index;
	}
	
	*/
	
	
	
	
	 static int findCompatibilityDifference(int first[], int second[])
	    {
	        int result = 0;
	        int n = first.length;
	      
	        for (int i = 0; i < n; i++) { 
	            if (first[i] != second[i]) {
	                int j = i + 1;
	                while (first[i] != second[j]) 
	                    j++;
	                  
	                while (j != i) {
	                    int temp = second[j - 1];
	                    second[j - 1] = second[j];
	                    second[j] = temp;
	                    j--;
	                    result++;
	                }
	            }
	        }
	        return result;
	    }

}
