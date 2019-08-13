package String;
/*
 * https://www.geeksforgeeks.org/program-print-substrings-given-string/
 * 
 * Input :  abcd
   Output :   a 
	          b
	          c
	          d
	          ab
	          bc
	          cd
	          abc
	          bcd
	          abcd
 */
public class PrintAllSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubString("abcd");
	}

	static void subString(String str) {
		for(int i = 1;i<=str.length();i++) {
			for (int k = 0; k+i <= str.length(); k++) {
				System.out.println(str.substring(k, k+i));
			}
		}
	}

	// Function to print all substring 
    public static void SubString(String str) 
    { 
    	int n  = str.length();
       for (int i = 0; i < n; i++)  
           for (int j = i+1; j <= n; j++) 
                System.out.println(str.substring(i, j)); 
    } 
}


