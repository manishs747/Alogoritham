package stack;

import java.util.*;





/*
 * 
 * 
 * 
 * 
 Sample Input

4
3
4 2 1 
6
1 1 5 4 3 2 
6
1 2 3 4 5 6
6
1 2 3 1 2 1

Sample Output

3 
11 
 * 
 */


public class RainHarvestSlimBuilding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numberOfInput = in.nextInt();
		for (int i = 0; i < numberOfInput; i++) {
			int[] arr = getInputList(in);
			System.out.println(getRainHarvested(arr));
		}
	}
	
	
	private static long getRainHarvested(int[] arr) {
		long water = 0;
	
		if(arr.length < 2){
			return 0;
		}
		Stack<Integer> maxStack = getMaxStack(arr);
		int maxSofar = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			int number = arr[i];
			int tmpWater = Math.min(maxSofar, maxStack.peek());
			water = water + tmpWater ;
			if(maxSofar < number){
				maxSofar = number;
			}
			if(!maxStack.isEmpty() && number == maxStack.peek() ){
				maxStack.pop();
			}
		}
		return water;
	}
	

	
 	public static int getRainHarvestedMemmorySolution(int[] arr) {
		int n = arr.length;
        if (n < 2)
            return 0;
        
        int left[] = new int[n];
        int right[] = new int[n];
        int water = 0;
        
        left[0] = 0;//excluding current ellement
        for (int i = 1; i < left.length; i++) {
        	left[i]= Math.max(arr[i-1],left[i-1] );
		}
       
        right[n-1] = arr[n-1];//including current ellement
        for (int i = n-2; i >= 0; i--) {
			right[i] = Math.max(arr[i], right[i+1]);
		}
        
        for (int i = 0; i < right.length; i++) {
        	water += Math.min(left[i],right[i]);
		}
		
		return water;
	}
 	
  

	


	private static Stack<Integer> getMaxStack(int[] arr) {
		Stack<Integer> maxStack = new Stack<Integer>();
		maxStack.push(arr[arr.length -1]);
		for (int i = arr.length - 2; i > 0; i--) {
			int num = arr[i];
			if(num >= maxStack.peek()){
				maxStack.push(num);
			}
		}
		return maxStack;
	}
	
	
	

	private static int[] getInputList(Scanner in) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = in.nextInt();
			}
	
		return arr;
	}

}
