package data_structure.arrays.online;


import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class ReduceArrayHalf {


    public static void main(String[] args) {
      /*  int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minSetSize(arr));*/

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        System.out.println(pQueue);
    }

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //priority in reverse


        return -1;
    }

    public static int minSetSizeMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Map<Integer, Integer> valueSortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int count = 0;
        int removed = 0;
        for (int key : valueSortedMap.keySet()) {
            if (removed >= arr.length / 2) {
                break;
            }
            removed += valueSortedMap.get(key);
            count++;
        }
        return count;
    }
}
