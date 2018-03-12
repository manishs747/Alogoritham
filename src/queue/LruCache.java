package queue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * https://www.interviewbit.com/problems/lru-cache/
 * 
 * https://www.geeksforgeeks.org/lru-cache-implementation/
 * 
 * https://www.hackerrank.com/contests/justcode/challenges/lru-implementtion/problem
 * 
 * http://chriswu.me/blog/a-lru-cache-in-10-lines-of-java/
 * 
 * 
 * 
 * 
 * It is same as HashMap instead maintains insertion order.  linked hashmap
 * 
 */
public class LruCache<K,V> {
	
	  private ConcurrentHashMap<K,V> map;
	  private ConcurrentLinkedQueue<K> queue;
	  private final int size; 

	  public LruCache(int size) {
	    this.size = size;
	    map = new ConcurrentHashMap<K,V>(size);
	    queue = new ConcurrentLinkedQueue<K>();
	  }

	  
	  public V get(K key) {
		    //Recently accessed, hence move it to the tail
		    queue.remove(key);//Removes a single instance of the specified element from this queue, if it is present
		    queue.add(key);//Inserts the specified element at the tail of this queue
		    return map.get(key);
		  }
	  
	  //putting 
	  public void put(K key, V value) {
		  //ConcurrentHashMap doesn't allow null key or values
		  if(key == null || value == null) throw new NullPointerException();
		  if(map.containsKey(key)){
			  queue.remove(key);
		  }
		  if(queue.size() >= size) {//removing least use
			  K lruKey = queue.poll();
			  if(lruKey != null) {
				  map.remove(lruKey);
			  }
		  }
		  queue.add(key);
		  map.put(key,value);
	  }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRUCaches<Integer, String> lruCache = new LRUCaches<Integer, String>(5);
		
		 System.out.println(" Pages for consideration : 2, 1, 0, 2, 8, 2, 4,99");
	        System.out.println("----------------------------------------------\n");


	        lruCache.put(2, "2");
	        lruCache.put(1, "1");
	        lruCache.put(0, "0");
	        System.out.println(lruCache + "  , After first 3 pages in cache");
	        lruCache.put(2, "2");
	        System.out.println(lruCache + "  , Page 2 became the latest page in the cache");
	        lruCache.put(8, "8");
	        System.out.println(lruCache + "  , Adding page 8, which removes eldest element 2 ");
	        lruCache.put(2, "2");
	        System.out.println(lruCache+ "  , Page 2 became the latest page in the cache");
	        lruCache.put(4, "4");
	        System.out.println(lruCache+ "  , Adding page 4, which removes eldest element 1 ");
	        lruCache.put(99, "99");
	        System.out.println(lruCache + " , Adding page 99, which removes eldest element 8 ");

	}

}
