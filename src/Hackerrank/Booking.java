package Hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Booking {

	public static void main(String[] args) {
		
	int[][] callsTimes = {{00,20},{00,40},{30,35}};
	System.out.println(howManyAgentsToAdd(3, callsTimes ));
		
		
	}
	
	
	
	
	
	
	public static long getScore(String keywords, String review) {
        long score = 0;
        Map<String, Long> freq = Stream.of(review.toLowerCase()
                .replace(".", "").replace(",", "").split(" "))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        String[] keyWordArray = keywords.toLowerCase().split(" ");
        for (String data : keyWordArray) {
            score += freq.getOrDefault(data, 0L);
        }
        return score;
    }

    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        Map<Integer, Long> scores = new HashMap<>();

        for (int i=0; i<hotel_ids.length; i++){
            long curScore = scores.getOrDefault(hotel_ids[i],0L);
            long newScore = curScore + getScore(keywords,reviews[i]);
            scores.put(hotel_ids[i],newScore);
        }
        
     return scores;

    }
	
	
	
	
	
	
	
	
	
	 static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
		 int concurrent = 0;
		 for (int i = 0; i < callsTimes.length-1; i++) {
			 int s1= callsTimes[i][0];
	         int e1 = callsTimes[i][1];
	         for (int j = i+1; j < callsTimes.length; j++) {
	        	 int s2 = callsTimes[j][0];
	        	 int e2 = callsTimes[j][1];
	        			
	        	if( checkOveralpping(s1, e1, s2, e2)){
	        		System.out.println(s1 +" " +e1+" "+s2+" "+e2);
	        		concurrent++;
	        	}
			 }
			
		   }
		 
		 int result = concurrent - noOfCurrentAgents;
		 if(result < 0){
			 result = 0;
		 }
		
		 return result;
	    }
	 
	 
	     static boolean checkOveralppingold(int s1,int e1,int s2,int e2){
	    	 if(s1>e2 || e1 < s2){
	    		 return false;
	    	 }else{
	    		 return true;
	    	 }
	     }
	     
	     static boolean checkOveralpping(int s1,int e1,int s2,int e2){
	    	 if(s1<=e2 && s2 <= e1){
	    		 return true;
	    	 }else{
	    		 return false;
	    	 }
	     }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 static int triangle(int a, int b, int c) {
		 if (checkIfValid(a,b,c)){
	            return 0;
	        }else if (a==b && b==c) {
	            return 1;
	        } else {
	            return 2;
	        }

	    }
	 
	 public static boolean  checkIfValid(int a, int b, int c){
	        boolean conditionA = a <= 0 || b<= 0 || c <= 0; // Check if all sides valid
	        boolean conditionB = a > b+c || b > a+c || c > a+b; // Check if can form a triangle

	        return conditionA && conditionB;
	    }

	   
	
	
	
	
	
	
	
	
	
	static int[] delta_encode(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(array[0]);
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int prev = array[i-1];
			int diff = current - prev;
			if(diff > 127 || diff < -127){
				list.add(-128);
			}
			list.add(diff);
		}
		
		
		 
		int [] arr = new int[list.size()];
		int i = 0;
         for (Integer it : list) {
        	 arr[i++] = it;
		 }
		return arr;
    }
	
	

}
