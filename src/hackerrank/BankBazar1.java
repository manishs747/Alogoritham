package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class BankBazar1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Scanner in = new Scanner(System.in);
		//int n = in.nextInt();
	   int number = 170;
	   System.out.println( getComplementNew(number));
	   // getMinimumDifference(null, null);
	  
		
	}
	
	
	static int[] getMinimumDifference(String[] a, String[] b) {
		
		int length = a.length;
		int [] result = new int[length];
		for (int i = 0; i < length; i++) {
			String s1 = a[i];
			String s2 = b[i];
			result[i] = getCountManipulation(s1, s2);
		}
		 return result;
    }
	
	
	private static int getCountManipulation(String s1 ,String s2) {
		
		 if(s1==null || s2==null || s1.length() != s2.length()){
      	   return -1;
         }
		   
		int count = 0;
	       int char_count[] = new int[26];
	       for (int i = 0; i < s1.length(); i++)
	           char_count[s1.charAt(i) - 'a']++;        
	       for (int i = 0; i < s2.length(); i++)
	           if (char_count[s2.charAt(i) - 'a']-- <= 0)
	               count++;
	       
	       return count;
	}


	private static int getCountManipulationOld(String s1 ,String s2) {
		   
		   if(s1==null || s2==null || s1.length() != s2.length()){
        	   return -1;
           }
	       // store the count of character
	       HashMap<Character,Integer> countMap =  new HashMap<Character, Integer>();
	       // iterate though the first String and update
	       // count
	       int count = 0;
	       for (int i = 0; i < s1.length(); i++)
	       {
	    	   if(!countMap.containsKey(s1.charAt(i))){
	    		   countMap.put(s1.charAt(i), 1);
	    	   }else{
	    		   countMap.put(s1.charAt(i), countMap.get(s1.charAt(i)+1));
	    	   }
	    	   if(!countMap.containsKey(s2.charAt(i))){
	    		   countMap.put(s2.charAt(i), -1);
	    	   }else{
	    		   countMap.put(s2.charAt(i), countMap.get(s2.charAt(i)-1));
	    	   }
	       }
	       for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
				count+=Math.abs(entry.getValue());
		   }
		       
	       return count;
	}
	  static int getComplementNew(int n){
		  
		  String binary = Integer.toBinaryString(n);
		  StringBuilder sb = new StringBuilder();
		   for (int i = 0; i < binary.length(); i++) {
			     int val = Character.getNumericValue(binary.charAt(i));
			    if(val == 0){
			    	val = 1;
			    }else{
			    	val = 0;
			    }
			     sb.append(val);
		    }
		  return Integer.parseInt(sb.toString(), 2);
	}
	
	private static int getHighestOneBit(int n){
		int count = 0;
		while(n> 0){
			count++;
			n = n >> 1;
		}
		return count;
	}

	private static int getComplement(int number) {
		 int ones = (1 << getHighestOneBit(number)) -1;
			return number^ones;		
	}
	
	private static int getComplementDiff(int number) {
		 int ones = (1 << Integer.highestOneBit(number)) -1;
			return number^ones;		
	}

}
