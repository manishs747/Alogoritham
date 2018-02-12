package String;

public class Regex {
	
	public static void main(String[] args) {
		
		 //String regex = "([1-5],)?([1-5],)?([1-5],)?([1-5],)?([1-5])?";
		//String regex = "[1-5],+";
		 String regex = "[0-5, /,]+";
		 

		// Negative test cases, should all be "false"
		//System.out.println("".matches(regex)); //incorrect, So False will be print
		     // positive test cases, should all be "true"
		 System.out.println("0,1,2,3,2".matches(regex));
		 
	
		 
		  
		
	}

}
