package Hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

 class DJfitenss extends Object{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		 TreeSet<Integer> list = new TreeSet<Integer>();
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int event = in.nextInt();
			if(event==2){
				//System.out.println(calculateRString(list));
			}else{
				 int steps = in.nextInt();
				 list.add(steps);
			}
           
           
		}

	}
	
	public static String calculateRString(List<Integer> list){
		int n = list.size();
	    n=n/3;
	    if(n==0){
	    	return "Not enough walks";
	    }
	    else{
	    	Collections.sort(list);
	    	return String.valueOf(list.get(list.size()-n));
	    }
	}

}
