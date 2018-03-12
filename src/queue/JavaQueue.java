package queue;

import java.util.*;

public class JavaQueue {
	
	public static void main(String[] args) {
		Queue<Integer> queueA = new LinkedList<Integer>();
		
		queueA.add(1);
		queueA.add(2);
		System.out.println(queueA);
		System.out.println(queueA.peek());
		System.out.println(queueA.poll());
		
		
		
	}

}
