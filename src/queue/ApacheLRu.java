package queue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

public class ApacheLRu {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cache<String, Eployee> citySlotsCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(150, TimeUnit.SECONDS)
                .build(null);
	
		try {
			citySlotsCache.get("key");
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
