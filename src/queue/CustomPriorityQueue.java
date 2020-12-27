package queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//data_structure.heap
		Queue<Book> queue=new PriorityQueue<Book>(10,Collections.reverseOrder());  
	    //Creating Books  
	    Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(233,"Operating System","Galvin","Wiley",6);  
	    Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    //Adding Books to the queue  
	    queue.add(b1);  
	    queue.add(b2);  
	    queue.add(b3);  
	    System.out.println("Traversing the queue elements:");  
	    //Traversing queue elements  
	    for(Book b:queue){  
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	    }  
	    queue.remove();  
	    System.out.println("After removing one book record:");  
	    for(Book b:queue){  
	        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	        }  

	}

}
