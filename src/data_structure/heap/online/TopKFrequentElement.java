package data_structure.heap.online;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {


    public static void main(String[] args) {

        int [] nums = {1,2,2,3,3,3};
        int k = 2;
        ArrayUtils.print(topKFrequent(nums,k));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int n:nums)
            countMap.put(n,countMap.getOrDefault(n,0)+1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get).reversed());
        for (int n:countMap.keySet()) {
            maxHeap.add(n);
        }
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));;
        int [] res = new int[k];
        for (int i = 0; i < k ; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

}
