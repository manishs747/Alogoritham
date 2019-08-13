package Hackerrank.atlasian;


import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;

import com.sun.org.apache.bcel.internal.classfile.Utility;

public class Solution1 {
	
	/*
	 
	 
	 3
	 1
	 2
	 3
	 2
	 2
	 3
	 
	 
	 
5
1
2
3
4
5
3
3
4
5
	 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int [] list1 = new int [n1];
		for(int i = 0;i < n1;i++) {
			list1[i] = in.nextInt();
		}
		
		int n2 = in.nextInt();
		int [] list2 = new int [n2];
		
        for(int i = 0;i < n2;i++) {
        	list2[i] = in.nextInt();
		}
        
        Array.Utility.print(list1);
        Array.Utility.print(list2);
     
       
		
		System.out.println(find(list1, list2));

	}
	
	
	public static int find(int [] list1,int [] list2) {
		int result = -1;
        int i = 0, j = 0; 
        int n = list1.length;
        int m = list2.length;
        if(n < m) {
        	return -1;
        }
 
        while (i < n && j < m) { 
            if (list1[i] == list2[j]) { 
                i++; 
                j++; 
                if (j == m) 
                    return i-m; 
            } 
            else { 
                i++; 
                j = 0; 
            } 
        } 
  
        return result; 
	}

}
