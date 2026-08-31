package Interview.atlas.comodity_pricing;

import java.util.*;
import java.util.Set;

public class StockPriceSET {

    // private int latestTime = 0;
    private final TreeMap<Integer, Integer> timestampToPrice = new TreeMap<>();
    private final TreeMap<Integer, Set<Integer>> priceToTimestamps = new TreeMap<>();

    public void update(int timestamp, int price) {
        // latestTime = Math.max(latestTime,timestamp);
        //remove old price
        if(timestampToPrice.containsKey(timestamp)){
          int oldPrice = timestampToPrice.get(timestamp);
          if (oldPrice == price) return; // no change

            priceToTimestamps.get(oldPrice).remove(timestamp);
          if(priceToTimestamps.get(oldPrice).isEmpty()){
              priceToTimestamps.remove(oldPrice);
          }
        }

        //update new price
        timestampToPrice.put(timestamp,price);
        priceToTimestamps.computeIfAbsent(price,k->new HashSet<>()).add(timestamp);

    }

    public int current() {
       return  timestampToPrice.lastEntry().getValue();
    }

    public int maximum() {
         return priceToTimestamps.lastKey();
    }

    public int minimum() {
        return priceToTimestamps.firstKey();
    }

}
