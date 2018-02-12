package stack.equalStack;

import java.util.Scanner;
import java.util.Stack;



//https://www.hackerrank.com/challenges/equal-stacks/problem

/*
 * 
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1

5 3 4
3 2 1 1 1
4 2 2
1 1 4 1


5
 * 
 * 
 */
	

public class EqualStack {
	
	private static class Pillar{
		private int height;
		private Stack<Integer> stack;
		Pillar(int height ,Stack<Integer> stack){
			this.height = height;
			this.stack = stack;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        int n1 = in.nextInt();
	        int n2 = in.nextInt();
	        int n3 = in.nextInt();
	        //int h1[] = new int[n1];
	        Stack<Integer> st = new Stack<Integer>();
	        Stack<Integer> s1 = new Stack<Integer>();
	        for(int h1_i=0; h1_i < n1; h1_i++){
	          st.push(in.nextInt());
	        }
	        int h1 = getStack(st, s1);
	        Pillar p1 =  new Pillar(h1, s1);
	        
	        Stack<Integer> s2 = new Stack<Integer>();
	        for(int h2_i=0; h2_i < n2; h2_i++){
	        	 st.push(in.nextInt());
	        }
	        int h2 = getStack(st, s2);
	        Pillar p2 =  new Pillar(h2, s2);
	        
	        Stack<Integer> s3 = new Stack<Integer>();
	        for(int h3_i=0; h3_i < n3; h3_i++){
	        	 st.push(in.nextInt());
	        }
	        int h3 = getStack(st, s3);
	        
	        Pillar p3 =  new Pillar(h3, s3);
	        
	        System.out.println(getLevelHeightNew(p1, p2, p3));
           
            
	}
	
	public static int getLevelHeightNew(Pillar p1,Pillar p2,Pillar p3){
		if(p1.stack.isEmpty() || p2.stack.isEmpty() || p3.stack.isEmpty()){
			return 0;
		}
		if((p1.height==p2.height)&&(p1.height==p3.height)){
			//System.out.println("returning from a");
			return p1.height;
		}
		
		while(p1.height != 0 || p2.height != 0 || p3.height != 0 ){
			
			//System.out.println("inside while loop directly");
			Pillar max = p1 ;
			if(p1.height < p2.height ){
				max = p2;
			}
			if(max.height < p3.height ){
				max = p3;
			}
			
			int rh = max.stack.pop();
			max.height = max.height - rh;
			if((p1.height == p2.height) && (p2.height == p3.height)){
				return p1.height;
			}
			//System.out.println("A height is "+p1.height);
		}
		
		//System.out.println("returning directly");
		return 0;
	}
	
	
	public static int getStack(Stack<Integer> source , Stack<Integer> destination){
		//System.out.println(source);
		int height = 0;
		while(!source.isEmpty()){
			int top = source.pop();
			height = height + top;
			destination.push(top);
		}
		return height;
	}

}
