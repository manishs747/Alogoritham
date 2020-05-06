package genricProblems;


/*a b c
    d
  e f g

T here are hourglasses in , and an hourglass sum is the sum of an hourglass' values.
Task Calculate the hourglass sum for every hourglass in */
public class Hourglass {
	
	public static void main(String[] args) {
		int[][] arr = get2dArray2();
		int maxSoFar = getHourClassSum(arr, 0, 0);
		for (int i = 0; i < arr.length-2; i++) {
			for (int j = 0; j < arr[i].length-2; j++) {
				 int curSum = getHourClassSum(arr, i, j);
				maxSoFar =  Math.max(maxSoFar, curSum);
				// System.out.print(  curSum +" , ");
			}
			//System.out.println();
		}
   
		System.out.println(maxSoFar);
	}

	public static int getHourClassSum(int[][] dd, int r,int c){
		int sum = 0;
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if((i==r+1)&&((j==c)||(j==c+2))){
					continue;
				}
					sum = sum + dd[i][j];
			}
		}
		return sum;
	}
	


	public static int [][] get2dArray() {
		return new int[][]{
				  { 1 ,1, 1, 0, 0, 0 },
				  { 0, 1, 0, 0, 0, 0 },
				  { 1, 1, 1, 0, 0, 0 },
				  { 0, 0, 2, 4, 4, 0 },
				  { 0, 0, 0, 2, 0, 0 },
				  { 0, 0, 1, 2, 4, 0 }
				};
	}

	public static int [][] get2dArray2() {
		return new int[][]{
				  { -1, -1, 0, -9, -2, -2},
				  { -2 ,-1, -6 ,-8, -2, -5 },
				  {-1 ,-1, -1, -2, -3 ,-4 },
				  {  -1, -9, -2, -4, -4, -5},
				  { -7, -3, -3, -2, -9, -9 },
				  { -1 ,-3 ,-1 ,-2 ,-4 ,-5 }
				};
	}
	
	
	
	
	
	
}
