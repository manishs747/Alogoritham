package Interview.atlas.comodity_pricing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {

    private int latestTime;
    // Store price of each stock at each timestamp.
    private Map<Integer, Integer> timestampPriceMap;
    // Store stock prices in increasing order to get min and max price.
    private TreeMap<Integer, Integer> priceFrequency;

    public StockPrice() {
      timestampPriceMap = new HashMap<>();
      priceFrequency = new TreeMap<>();
      latestTime = 0;
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime,timestamp);
        // If same timestamp occurs again, previous price was wrong. and old price need to be updated
        if(timestampPriceMap.containsKey(timestamp)){
            int oldPrice = timestampPriceMap.get(timestamp);
            priceFrequency.put(oldPrice,priceFrequency.get(oldPrice)-1);
            if(priceFrequency.get(oldPrice) == 0){
                priceFrequency.remove(oldPrice);
            }
        }
        //update latest new price
        timestampPriceMap.put(timestamp,price);
        priceFrequency.put(price,priceFrequency.getOrDefault(price,0)+1);
    }

    public int current() {
        return  timestampPriceMap.get(latestTime);
    }

    public int maximum() {
       return priceFrequency.lastKey();
    }

    public int minimum() {
           return priceFrequency.firstKey();
    }
}
