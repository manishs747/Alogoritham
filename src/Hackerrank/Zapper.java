package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Zapper {
	
	public static void main(String[] args) {
		
		
		int[] elements = {1,2,1,3,2,3};
		System.out.println(maxPoints(elements ));
		
	}
	
	static int pointsBelongToTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int xP, int yP, int xQ, int yQ) {
		
		int s = (y3 - y2) * x1 + (x2 - x3) * y1 + (x3 * y2 - x2 * y3);
		if(s == 0){
			return 0;
		}
		
		int result = 0;
		
		 boolean p = isInside(x1, y1, x2, y2, x3, y3, xP, yP);
		 boolean q = isInside(x1, y1, x2, y2, x3, y3, xQ, yQ);
		 if(p == true){
			 result = result +1;
		 }
		 if(q == true){
			 result = result +2;
		 }
		 
		 if(p == false && q == false){
			 result = 4;
		 }
		 
		 return result;
		
		
    }
	
	static double area(int x1, int y1, int x2, int y2,
			int x3, int y3)
	{
		return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
				x3*(y1-y2))/2.0);
	}


	static boolean isInside(int x1, int y1, int x2,
			int y2, int x3, int y3, int x, int y)
	{   
		double A = area (x1, y1, x2, y2, x3, y3);
		double A1 = area (x, y, x2, y2, x3, y3);
		double A2 = area (x1, y1, x, y, x3, y3);
		double A3 = area (x1, y1, x2, y2, x, y);
		return (A == A1 + A2 + A3);
	}
	
	
	
		



	public  static long maxPoints(int[] elements) {
		long result = 0;
        Map<Integer,Integer> m = new HashMap<>();
        int max = elements[0];
        for (int i = 0; i < elements.length; i++) {
        	int value = elements[i];
			if(m.containsKey(value)){
			m.put(value, m.get(value)+1);
			}else{
				m.put(value, 1);
			}
			if(max*m.get(max) < value*m.get(value)){
				max = value;
			}
		}
		
        while(!m.isEmpty()){
        	int maxKey = Integer.MIN_VALUE;
        	for (Map.Entry<Integer, Integer> entry : m.entrySet())
        	{
        		int val = entry.getKey()*entry.getValue();
        		if(maxKey == Integer.MIN_VALUE){
        			maxKey = entry.getKey();
        		}else{
        			if(maxKey*m.get(maxKey) < val){
        				maxKey = entry.getKey();
        			}
        		}
        	}
        	result = result + maxKey*m.get(maxKey);
        	m.remove(maxKey);
        	if(!m.containsKey(maxKey+1) && m.containsKey(maxKey-1) ){
        		m.remove(maxKey-1);
        	}
            if(!m.containsKey(maxKey-1)&& m.containsKey(maxKey+1)){
            	m.remove(maxKey+1);
        	}
            if(m.containsKey(maxKey+1) && m.containsKey(maxKey-1)){
            	int left = maxKey-1;
            	int right = maxKey+1;
            	int smaller = left*m.get(left) < right*m.get(right) ? left : right;
            	m.remove(smaller);
            }
        	
        }
		
		
		
		return result;
    }
	
	
	
	


static String isPossible(int a, int b, int c, int d) {
	String result = "No";
	if(a>c || b > d){
		return result;
	}
	if(a==c && b == d){
		return result = "Yes";
	}
	
	String result1 = isPossible(a+b, b, c, d);
	String result2 = isPossible(a, a+b, c, d);
	
	if(result1.equals("Yes") || result2.equals("Yes")){
		return "Yes";
	}else{
		return "No";
	}
}
	
}
