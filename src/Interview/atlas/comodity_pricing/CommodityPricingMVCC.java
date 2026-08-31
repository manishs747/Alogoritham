package Interview.atlas.comodity_pricing;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommodityPricingMVCC {


    private final Map<Integer, TreeMap<Integer, Integer>> timestampToCheckpointPrice = new HashMap<>();

    // upsert with checkpoint
    public void upsertCommodityPrice(int timestamp, int price, int checkpointId) {
        timestampToCheckpointPrice
                .computeIfAbsent(timestamp, k -> new TreeMap<>())
                .put(checkpointId, price);
    }

    // get price at given checkpoint
    public int getCommodityPrice(int timestamp, int checkpointId) {
        TreeMap<Integer, Integer> checkpointToPrice = timestampToCheckpointPrice.get(timestamp);
        if (checkpointToPrice == null) return -1;

        Map.Entry<Integer, Integer> entry = checkpointToPrice.floorEntry(checkpointId);
        return entry == null ? -1 : entry.getValue();
    }
}
