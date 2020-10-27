package data_structure.strings;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	/*
	 * Formula
	 *  Time complexity - O(n2)
     *  Space complexity - O(n2)
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	public static int longestPossibleSubsequenceIterative(String str){
		int length = str.length();
		int T[][] = new int[length][length];
		 for(int i=0; i < str.length(); i++){
	            T[i][i] = 1;
	        }
		 //l is lenght of matrix going down
		 for(int l = 2; l <= length; l++){
			 for (int i = 0; i < length - l+1; i++) {
				 int j = i + l -1;
				   if (str.charAt(i) == str.charAt(j) && l == 2)
	                   T[i][j] = 2;
	                else if (str.charAt(i) == str.charAt(j))
	                   T[i][j] = T[i+1][j-1] + 2;
	                else
	                   T[i][j] = Math.max(T[i][j-1], T[i+1][j]);
	            }	
		 }
		return T[0][length-1];
	}
	
     public static int calculateRecursive(char str[],int start,int len){
    	  if(len == 1){
              return 1;
          }
          if(len ==0){
              return 0;
          }
          if(str[start] == str[start+len-1]){
              return 2 + calculateRecursive(str,start+1,len-2);
          }else{
              return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
          }
	}
	
	

	

}
