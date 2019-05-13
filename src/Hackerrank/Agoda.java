package Hackerrank;

import java.util.Scanner;

public class Agoda {
	
	
	
	public static void main(String[] args) {
		int origin [] = {1,2,4,6};
		int dest [] = {3,3,3,4};
		
		utils.ArrayUtils.print(connectedCities(3,1,origin,dest));
	}
	
	
	
	
	
	static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
		 n = originCities.length;
		int result [] = new int [n];
		for (int i = 0; i < n; i++) {
			int origin = originCities[i];
			for (int j = 0; j < n; j++) {
				int dest = destinationCities[j];
				int gcd = gcd(origin,dest);
				if(gcd > g){
					result[i] = 1;
					break;
				}
			}
			
			
		}
		return result;

    }
	
	 static int gcd(int a, int b)
	    {
	        if (a == 0) 
	            return b;
	         
	        return gcd(b%a,a);
	    }
	
	private static int getLcm(int a, int b) {
		 int n = gcd(a, b);
	      
	        int result = 0;
	        for (int i=1; i<=Math.sqrt(n); i++)
	        {
	           
	            if (n%i==0)
	            {
	                if (n/i == i)
	                    result += 1;
	                else
	                    result += 2;
	            }
	        }
	        return result;
	}
	
	
	
	
	
	
	
	/*
	
	  n = originCities.length;
      int result [] = new int [n];
		for (int i = 0; i < n; i++) {
			int origin = originCities[i];
			int dest = destinationCities[i];
			int gcd = gcd(origin,dest);
			//System.out.println("HCM of "+origin+" "+dest+" = "+lcm);
			if(gcd > g){
				result[i] = 1;
			}
			
		}
		return result;
	*/
	
	
	
	
	
	
	
	
	





	static int ironMan(int[] p) {
		int result = 0;
		int sum = 0;
		for (int num : p) {
			sum = sum + num;
			if (sum < 1) {
				int tmp = 1 - sum;
				sum = sum + tmp;
				result = result + tmp;
			}
		}
		return result;
	}

}
