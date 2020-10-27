package data_structure.arrays.arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<Integer> list = new ArrayList<Integer>();  //3, 30, 34, 5, 9
		 
		 /*
		 list.add(3);
		 list.add(30);
		 list.add(34);
		 list.add(5);
		 list.add(9);*/
		 
		 list.add(0);
		 list.add(0);
		 list.add(0);
		 System.out.println(largestNumber(list));  //9534330
		

	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static String largestNumber(final List<Integer> A) {
		
		if(A.isEmpty()) {
			return "0";
		}

		Collections.sort(A, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				String x = String.valueOf(o1);
				String y  = String.valueOf(o2);
				String xy=x + y; 
				String yx= y + x; 
				return xy.compareTo(yx) >0 ?-1:1 ;
			} 
			
		});
		
		String result = "";
		for (Integer val : A) {
			result= result + val;
		}
		if( result.charAt(0) == '0') {
			return "0";
		}
		
		return result;
		
		
		
    }
	

}
