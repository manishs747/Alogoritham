package data_structure.heap;


import java.util.*;

/**
 *
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
     /*   int[] arr = {1, 1, 1, 2, 2, 3};
        ArrayUtils.print(topKFrequent(arr, 2));
        System.out.println(Integer.compare(1, 2));*/
        String[] arrStr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(arrStr, 4));
    }


    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (int key : freqMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[] ans = new int[k];
        while (k > 0) {
            ans[--k] = minHeap.poll();
        }
        return ans;
    }

    /**
     * https://leetcode.com/problems/top-k-frequent-words/
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        Queue<String> minHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) == freqMap.get(b) ? b.compareTo(a) : freqMap.get(a) - freqMap.get(b));
        for (String key : freqMap.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }
        return result;
    }


}
