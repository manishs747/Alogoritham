package hackerrank;

import java.util.Scanner;

public class MuditAndFood {
	
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int  Cmax = in.nextInt();
		int k = in.nextInt();
		
		int food[] = new int[N];
		for (int i=0;i<N ; i++) {
			food[i] = in.nextInt();
		}
		int count = 0;
		
		for (int i=0;i<N - k ; i++) {
			 boolean valid = true;
			for (int j = 0; j < k; j++) {
				int val = food[i+j] ;
				if(val > Cmax){
					valid = false;
					continue;
				}
			}
			if(valid){
				count = count+ 1;
			}
			
		}
		
		System.out.println(count);
		
    }
	
	

}
