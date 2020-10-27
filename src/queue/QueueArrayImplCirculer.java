package queue;

import java.util.Arrays;

import data_structure.arrays.Utility;


//https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
public class QueueArrayImplCirculer {
	
	    int front, rear, size;
	    int  capacity;
	    int array[];
	    
	    public boolean isEmpty(){
			return (size == 0);
		}
	    
	    
	    public boolean isFull(){
			return (size == capacity);
		}
	    
	    public QueueArrayImplCirculer(int capacity) {
	         this.capacity = capacity;
	         front = -1; 
	         rear = -1;
	         array = new int[this.capacity];
	           
	    }
	    private void ensureCapacityHelper() {
	        // overflow-conscious code
	        if (size == capacity){
	        	 grow();
	        }
	    }
	    
	    private void grow() {
	        // overflow-conscious code
	        int newCapacity =  array.length*2;
	        int oldCapacity = capacity;
	        capacity = newCapacity;
	        array = Arrays.copyOf(array, newCapacity);
	        if(front > rear){
	        	fixArray(oldCapacity);
	        }
	    }
	    
	    private void fixArray(int oldCapacity) {
			// TODO Auto-generated method stub
	    	for (int i = 0;i < front; i++) {
				array[oldCapacity+i] = array[i];
			 }
	    	rear = oldCapacity+rear;
		}


		public void add(int data){
	    	ensureCapacityHelper();
	    	if(isEmpty()){
	    		front = (front+1)%capacity;
	    	}
	    	rear = (rear+1)%capacity;
	    	array[rear] = data;
	    	size++;
		}
	    
	    
	    public int poll(){
	    	if(isEmpty()){
	    		return -1;
	    	}
	    	 size--;
	    	int data = array[front];
	    	array[front] = -1;
	    	if(!isEmpty()){
	    		front = (front+1)%capacity;
	    	}
	    	
	       
	     return data;
		}
	    
	    @Override
	    public String toString() {
	    // TODO Auto-generated method stub
	    Utility.print(array);
	    return "";
	    }
	    
	    
	    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueArrayImplCirculer queue = new QueueArrayImplCirculer(3);
		queue.add(2);
		queue.add(3);
		queue.add(5);
		queue.poll();
		queue.poll();
		queue.add(8);
		queue.add(9);
		System.out.println(" Front:"+queue.front+" Rear:"+queue.rear);
		System.out.println(queue);
		
		queue.add(10);
		queue.add(11);
		queue.add(12);
		System.out.println("After resizew Front:"+queue.front+" Rear:"+queue.rear);
		System.out.println(queue);
		queue.add(13);
		System.out.println("After resizew Front:"+queue.front+" Rear:"+queue.rear);
		System.out.println(queue);
		/*System.out.println("Removing 2 Front:"+queue.front+" Rear:"+queue.rear);
		queue.poll();
		System.out.println("Removing 3 Front:"+queue.front+" Rear:"+queue.rear);
		queue.poll();
		System.out.println("Removing 5 Front:"+queue.front+" Rear:"+queue.rear);
		queue.add(8);
		System.out.println("Adding 8 Front:"+queue.front+" Rear:"+queue.rear);
		System.out.println(queue);  */
	}

}
