package algorithams.binarysearch;

import java.util.NavigableMap;
import java.util.TreeMap;

public class MaximumBeauty {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");

        // Example key for which to find the floor
        int input = 25;

        // Get the floor entry (largest entry less than or equal to input)
        var floorEntry = map.floorEntry(input);
        if (floorEntry != null) {
            System.out.println("Floor entry for " + input + " is: " + floorEntry.getKey() + " -> " + floorEntry.getValue());
        } else {
            System.out.println("No floor entry found for " + input);
        }
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        return null;
    }


}
