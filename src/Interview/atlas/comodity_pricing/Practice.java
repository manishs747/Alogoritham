package Interview.atlas.comodity_pricing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Practice {

    private final TreeMap<Integer, Integer> timestampToPrice = new TreeMap<>();
    private final TreeMap<Integer, Set<Integer>> priceToTimestamps = new TreeMap<>();


    /*
       if(update -> remove old price from system)
       add the new price
     */
    public void update(int timestamp, int price) {

        //remove old price from system
        if(timestampToPrice.containsKey(timestamp)){
            int oldPrice = timestampToPrice.get(timestamp);
            if(oldPrice == price) return;

            priceToTimestamps.get(oldPrice).remove(timestamp);
            if(priceToTimestamps.get(oldPrice).isEmpty()){
                priceToTimestamps.remove(oldPrice);
            }

        }

        //add new price
         timestampToPrice.put(timestamp,price);
         priceToTimestamps.computeIfAbsent(price,k->new HashSet<>()).add(timestamp);
    }
}
