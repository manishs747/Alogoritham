package data_structure.arrays;

public class MinMax {
	
	public static class Pair{
		 public static int min;
		 public static int max;
		 public Pair(int i, int j) {
		  this.min = i;
		  this.max = j;
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {1000, 11, 445, 1, 330, 3000,5};
		//Pair pair = getMinMax(arr);
		Pair pair = findMinMaxRecursive(arr,0,arr.length-1);
		System.out.println("Min is "+pair.min + " Max is "+ pair.max);
		
	}
	
	
	
	public static Pair getMinMax(int arr[]){
		Pair pair = new Pair(arr[0],arr[0]);
		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			if(current > pair.max){
				pair.max = current;
			}
			if(current < pair.min){
				pair.min = current;
			}
		}
		return pair;
	}
	
	public static Pair findMinMaxRecursive(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end)
			return new Pair(arr[start], arr[start]);
		int mid = (start + end) / 2;
		Pair lpair = findMinMaxRecursive(arr, start, mid);
		Pair rpair = findMinMaxRecursive(arr, mid + 1, end);
		if (lpair == null) {
			return rpair;
		} else if (rpair == null) {
			return lpair;
		}
		System.out.println("Start is:" + start + " MID POINT:" + mid
				+ " end is:" + end);
		System.out.println("LEFT MAX:" + lpair.max + "RIGHT MAX:" + rpair.max);
		return new Pair(Math.min(lpair.min, rpair.min), Math.max(lpair.max,
				rpair.max));
	}



	

}
