package hackerrank;

import java.util.Arrays;


/*
 * 
http://blog.cancobanoglu.net/2016/09/18/interview-questions-string-chain/
6 
a 
b 
ba 
bca 
bda 
bdca 
 * 
 */

public class ClearTrip {
	
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
		String[] words = {"a", "b", "ab", "bca", "bda", "bdca"};
		//String[] words = {"a", "b", "ab", "bca"};
		//String[] words = {"a", "b", "ca", "bca", "bda", "bdca"};
		System.out.println(longestChain(words));
	}
	
	
	 static int longestChain(String[] words) {
		 
		 return compute(getPair(words));
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
	
	static int compute(Pair[] words){
		int N = words.length;
		int[]dp = new int[N];
		dp[0] = 1;
		
		for(int i=1; i<N; i++){
			int max = 1;
			
			for(int j=i-1; j>=0; j--){
				System.out.println(words[i].str+" word j = "+words[j].str);
				if(words[i].count - words[j].count > 0){
					if(words[i].count - words[j].count == 1){
						String arrI = words[i].str;
						for(int rem = 0; rem<arrI.length(); rem++){
							String afterR = arrI.substring(0, rem) + arrI.substring(rem+1, arrI.length());
							System.out.println(arrI+" :Substrong for 0 to Rem"+rem+" value: "+arrI.substring(0, rem)+"  after: "+arrI.substring(rem+1, arrI.length())+"  After R : "+afterR);
							if(afterR.equals(words[j].str)){
								if(dp[j] + 1 > max){
									max = dp[j]+1;
								}
							}
						}
					}
					else{
						break;
					}
				}
			}
			dp[i] = max;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++){
			if(dp[i] > max){
				max = dp[i];
			}
		}
		return max;
	}

}
