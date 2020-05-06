package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/30-dictionaries-and-maps
 * sample input 
 * 
 * Sample Input

3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry

Sample Output

sam=99912222
Not found
harry=12299933
 * 
 * 
 */



public class DictionariesMaps {

	public DictionariesMaps() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        Map<String,Integer> myMap = new HashMap<String,Integer>(); 
	        for(int i = 0; i < n; i++){
	            String name = in.next();
	            int phone = in.nextInt();
	            myMap.put(name,phone);
	        }
	        System.out.println();
	        while(in.hasNext()){
	            String s = in.next();
	            if(myMap.containsKey(s)){
	                System.out.println(s+"="+myMap.get(s));
	            }else{
	               System.out.println("Not found"); 
	            }
	            // Write code here
	        }
	        in.close();
	    }

}
