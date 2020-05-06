package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/sparse-arrays?h_r=next-challenge&h_v=zen

/*
 4
aba
baba
aba
xzxb
3
aba
xzxb
ab



2
1
0
 */

public class SparseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<String,Integer> input = new HashMap<String, Integer>();
		for (int i=0;i<n;i++) {
			String key = in.next();
			if(input.containsKey(key)){
				input.put(key, input.get(key)+1);
			}else{
				input.put(key, 1);
			}
		}
		
		int k = in.nextInt();
		
		for (int i=0;i<k;i++) {
		  String key =	in.next();
			if(input.containsKey(key)){
				System.out.println(input.get(key));
			}else{
				System.out.println(0);
			}
			
		}

	}

}
