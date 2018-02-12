package queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Book implements Comparable<Book> {
	
	int id;  
	String name,author,publisher;  
	int quantity; 
	
	public Book(int id, String name, String author, String publisher, int quantity) {  
	    this.id = id;  
	    this.name = name;  
	    this.author = author;  
	    this.publisher = publisher;  
	    this.quantity = quantity;  
	} 

	@Override
	public int compareTo(Book b) {
		  if(id>b.id){  
		        return 1;  
		    }else if(id<b.id){  
		        return -1;  
		    }else{  
		    return 0;  
		    }
	}
	
	
	public static void main(String[] args) {
		Queue<Book> queue=new PriorityQueue<Book>(10,Collections.reverseOrder());  
	    //Creating Books  
	    Book b1=new Book(9,"Let us C","Yashwant Kanetkar","BPB",8);  
	    Book b2=new Book(5,"Operating System","Galvin","Wiley",6);  
	    Book b3=new Book(3,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
	    //Adding Books to the queue  
	    queue.add(b1);  
	    queue.add(b2);  
	    queue.add(b3);  
	    System.out.println("Traversing the queue elements:");  
	    //Traversing queue elements  
	    for(Book b:queue){  
	    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
	    }  
	    while(!queue.isEmpty()){
	    	Book b = queue.poll();
	    	System.out.println(b.id);
	    }
	    
	    
	}

}
