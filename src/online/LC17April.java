package online;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC17April {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(arr));
    }

    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : tasks) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        int count = 0;
        for (int val : freqMap.values()) {
            if (val == 1) return -1;
            count += (val+2)/3;
        }
        return count;
    }


    public static int maxTrailingZeros(int[][] grid) {


        return -1;
    }


    public static String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        String str = "";
        int count = 0, sum = 0;
        for (char c : s.toCharArray()) {
            if (count == k) {
                str += sum;
                count = 0;
                sum = 0;
            }
            sum += Character.getNumericValue(c);
            count++;
        }
        str += sum;
        return digitSum(str, k);
    }

    /**
     * Java Solution Using MaxHeap
     * Storing count of each task in max heap and reducing by 3 or 2
     */
    public static int minimumRounds2(int[] tasks) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : tasks) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get).reversed());
        for (int key : freqMap.keySet()) maxheap.add(key);
        int count = 0;
        while (!maxheap.isEmpty()) {
            int key = maxheap.poll(), valCount = freqMap.get(key);
            if (valCount < 2) return -1;
            count++;
            if (valCount > 3) {
                valCount -= (valCount % 2 == 0 && valCount - 3 == 1) ? 2 : 3; //checking if selecting 3 will make count as 1
                freqMap.put(key, valCount);
                maxheap.add(key);
                continue;
            }
        }
        return count;
    }


}
