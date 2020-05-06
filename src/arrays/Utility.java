package arrays;

public class Utility {
	
	public static void print(int[][] puzzle) {
        for (int[] row : puzzle) {
            for (int elem : row) {
                System.out.printf("%4d", elem);
            }
            System.out.println();
        }
        System.out.println();
    }
	
	
	public static void print(int[] arr) {
        
            for (int elem : arr) {
                System.out.print(elem+" ");
            }
         
        System.out.println();
    }
	
	
	public static void print(double[] arr) {
        
        for (double elem : arr) {
            System.out.print(elem+" ");
        }
     
    System.out.println();
}
	
	public static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }
	
	public static void printString(String[] arr) {
        
        for (String elem : arr) {
            System.out.print(elem+" ");
        }
     
    System.out.println();
}

}
