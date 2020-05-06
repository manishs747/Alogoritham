package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	for (int i = 0; i < n; i++) {
		int val = s.nextInt();
		System.out.println(numberWays(val, 0, new HashMap<String, Integer>()));
	}
	

	}
	
	
	
	
	public static int numberWays(int n ,int count,Map<String,Integer> map){
		if(n == 1|| n == 2){
			return 0;
		}
		if(n == 3){
			return 1;
		}
		
		
		int mid = (int) Math.ceil(n/2.0);
		System.out.println("MID:"+mid);
		count = 0;
		if(map.containsKey("stair_"+n)){
			return map.get("stair_"+n);
		}
		System.out.println("INPUT "+n);
		for (int i = 1; i <= mid; i++) {
			System.out.println("INP:"+n);
			count +=  numberWays(n-i,count,map);
		}
		map.put("stair_"+n, count);
		return count;
	}

}
