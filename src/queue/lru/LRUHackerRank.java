package queue.lru;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import Array.Utility;

/*
 *  10 4
    1 2 3 2 5 3 4 5 8 9
    Sample Output
    7
    9 8 5 4
 */


public class LRUHackerRank {
	
	 // store keys of cache 
    static Deque<Integer> dq;   
    // store references of key in cache  
    static HashSet<Integer> map; 
    //maximum capacity of cache  
    static int csize; 
    
    LRUHackerRank(int n) 
    { 
        dq=new LinkedList<>(); 
        map=new HashSet<>(); 
        csize=n; 
    } 

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int listSize = in.nextInt();
		int capacity = in.nextInt();
		LRUHackerRank lru = new LRUHackerRank(capacity);
		int pageFault = 0;
		for (int i = 0; i < listSize; i++) {
			pageFault += lru.refer(in.nextInt());
		}
		System.out.println(pageFault);
		lru.display();
		
	}
	
	 /* Refers key x with in the LRU cache */
    public int refer(int x) {
    	if (map.contains(x)) {
    		dq.remove(x);  //its taking o(n)
    		dq.addFirst(x);
    		return 0;
    	}else {
    		dq.addFirst(x);
    		map.add(x);
    		if(dq.size() > csize) {
    			x = dq.removeLast();
    			map.remove(x);
    		}
    		return 1;
    	}
    }
    // display contents of cache  
    public void display() { 
        Iterator<Integer> itr = dq.iterator(); 
        while(itr.hasNext()) 
        { 
            System.out.print(itr.next()+" "); 
        } 
    }

}
