package Array;

public class Table {
	
	public static  String w = "Weird";
	public static  String nw = "Not Weird";
	
	
	
	public static void main(String[] args) {
		print(24);
	}
	
	/*
	 * If  is odd, print Weird
If  is even and in the inclusive range of 2  to 5 , print Not Weird
If  is even and in the inclusive range of  to , print Weird
If  is even and greater than , print Not Weird
	 */
	public static void print(int n) {
		String result = null;
		if(n%2 != 0) {
			System.out.println("CASE 1");
			result = w;
		}else if (n >= 2 && n <= 5) {
			System.out.println("CASE 2");
			result = nw;
		} else if(n >= 6 && n <= 20 ) {
			System.out.println("CASE 3");
			result = w;
		}
        else if(n > 20) {
        	System.out.println("CASE 4");
        	result = nw;
        }
		System.out.println(result);
	}
	
	
	

}
