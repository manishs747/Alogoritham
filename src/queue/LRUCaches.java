package queue;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCaches<K, V> extends LinkedHashMap<K, V> {
	
	 private int cacheSize;

	  public LRUCaches(int cacheSize) {
	    super(16, (float) 0.75, true);
	    this.cacheSize = cacheSize;
	  }

	  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
	    return size() >= cacheSize;
	  }
	  
	  
	  public static void main(String[] args) {
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
