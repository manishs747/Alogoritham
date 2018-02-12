package Hackerrank;

import java.util.Arrays;

import Hackerrank.ClearTrip.Pair;

public class StringChainForLoop {
	
	static class  Pair implements Comparable<Pair>{
		String str;
		int count;
		
		Pair(String str){
			this.str = new String(str);
			count = str.length();
		}
		
		public int compareTo(Pair p){
			return this.count - p.count;
		}
	}

	public static void main(String[] args) {
		//String[] words = {"a", "b", "ab", "bca", "bda", "bdca"};
		String[] words = {"a", "b", "ab", "bca"};
		System.out.println(longestChain(words));

	}
	
 static int longestChain(String[] words) {
	return 0;
		 
		// return compute(getPair(words));
	 }
 
 private static  Pair[]  getPair(String[] words) {
		int N = words.length;
		Pair[]arr = new Pair[N];
		
		
		for(int i=0; i<N; i++){
			String s = words[i];
			arr[i] = new Pair(s);
		}
		Arrays.sort(arr);
		
		return arr;
		
	}
 
 
 

}
