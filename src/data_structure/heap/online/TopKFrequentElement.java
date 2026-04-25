package data_structure.heap.online;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/top-k-frequent-elements/?envType=company&envId=oracle&favoriteSlug=oracle-thirty-days
 */
public class TopKFrequentElement {


    public static void main(String[] args) {

        int [] nums = {1,2,2,3,3,3};
        int k = 2;
        ArrayUtils.print(topKFrequent2(nums,k));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> map.get(o)).reversed());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           pq.offer(entry.getKey());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> map.get(o)));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }



}
