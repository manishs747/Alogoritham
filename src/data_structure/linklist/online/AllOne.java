package data_structure.linklist.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

    // Doubly linked list node representing one popularity level
    private static class Bucket {
        int popularity;
        Set<String> ids = new HashSet<>();
        Bucket prev, next;
        Bucket(int popularity) { this.popularity = popularity; }
    }

    private Bucket head,tail;
    private final Map<String,Integer> contentToPopularity = new HashMap<>();
    private final Map<Integer,Bucket> popularityToBucket = new HashMap<>();
    public AllOne() {
      head = new Bucket(Integer.MIN_VALUE);
      tail = new Bucket(Integer.MAX_VALUE);
      head.next = tail;
      tail.prev = head;
    }

    public void inc(String key) {
       int oldPopularity = contentToPopularity.getOrDefault(key,0);
       int newPopularity = oldPopularity+1;
       Bucket oldBucket = popularityToBucket.get(oldPopularity);

       //add
        contentToPopularity.put(key,newPopularity);
        //add new to popular map
        Bucket newBucket = popularityToBucket.get(newPopularity);
        if(newBucket == null){
            newBucket = new Bucket(newPopularity);
            insertBucketAfter(oldBucket == null? head:oldBucket,newBucket);
        }
        newBucket.ids.add(key);
        popularityToBucket.put(newPopularity,newBucket);

        //remove key from old bucket
        if(oldBucket != null){
            oldBucket.ids.remove(key);
            if(oldBucket.ids.isEmpty()){
                removeBucket(oldBucket);
            }
        }
    }

    private void removeBucket(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        popularityToBucket.remove(bucket.popularity);
    }

    public void dec(String key) {
         if(!contentToPopularity.containsKey(key)) return;
         int oldPopularity = contentToPopularity.get(key);
         int newPopularity = oldPopularity -1;

        Bucket oldBucket = popularityToBucket.get(oldPopularity);
        //code to remove
        oldBucket.ids.remove(key);
        if(oldBucket.ids.isEmpty()) removeBucket(oldBucket);

         //add or update
         if(newPopularity > 0){
             contentToPopularity.put(key,newPopularity);
             Bucket newBucket = popularityToBucket.get(newPopularity);
             if(newBucket == null){
                 newBucket = new Bucket(newPopularity);
                 insertBucketAfter(oldBucket.prev,newBucket);
                 popularityToBucket.put(newPopularity,newBucket);
             }
             newBucket.ids.add(key);
         }else {
             contentToPopularity.remove(key);
         }
    }

    public String getMaxKey() {
      if(popularityToBucket.isEmpty()) return "";
        return  tail.prev.ids.iterator().next();
    }

    public String getMinKey() {
        if(popularityToBucket.isEmpty()) return "";
        return  head.next.ids.iterator().next();
    }

    /**********Helper************/

    private void insertBucketAfter(Bucket prev, Bucket newBucket) {
        newBucket.next = prev.next;
        prev.next.prev = newBucket;
        newBucket.prev = prev;
        prev.next = newBucket;
    }


}
