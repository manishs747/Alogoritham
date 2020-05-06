package genricProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RomanizerClass {
	
	
	private final static TreeMap<Integer,String> map = new  TreeMap<Integer, String>();
	static{
		    map.put(1000, "M");
	        map.put(900, "CM");
	        map.put(500, "D");
	        map.put(400, "CD");
	        map.put(100, "C");
	        map.put(90, "XC");
	        map.put(50, "L");
	        map.put(40, "XL");
	        map.put(10, "X");
	        map.put(9, "IX");
	        map.put(5, "V");
	        map.put(4, "IV");
	        map.put(1, "I");
	}
	
	public static void main(String[] args) {
		
	     for (int i = 1; i<= 100; i++) {
		   //     System.out.println(i+"\t =\t "+toRoman(i));
		    }
		
		 System.out.println(toRoman(96));
	
		
	}
	
	
	public final static String toRoman(int number){
		int l = map.floorKey(number);
		System.out.println(l);
		if(map.containsKey(number)){
			return map.get(number);
		}
		//System.out.println(map.get(l));
		return map.get(l)+toRoman(number-l);
	}
	
	public static List<Integer> getNumberArray(int num){
		List<Integer> numlist = new ArrayList<Integer>();
		while(num != 0){
			numlist.add(num%10);
		 	num = num/10;
		 	
		}
		return numlist;
		
	}



}
