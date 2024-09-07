package data_structure.heap.online;

import java.util.*;

public class LeastKRemovals {


    public static void main(String[] args) {
       int  arr [] = {4,3,1,1,3,3,2};
       int  k = 3;
       System.out.println(findLeastNumOfUniqueIntsSorting(arr,k));
    }


    public static int findLeastNumOfUniqueIntsSorting(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies);
        for (int i = 0; i < frequencies.size() ; i++) {
            k -= frequencies.get(i);
            if(k < 0) return frequencies.size() - i;
        }
        return 0;
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int n:arr)
            countMap.put(n,countMap.getOrDefault(n,0)+1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        minHeap.addAll(countMap.keySet());
         while (k-- > 0)  {
           int key = minHeap.remove();
           int count = countMap.get(key);
           if(count == 1){
               countMap.remove(key);
           }else {
               countMap.put(key,count-1);
               minHeap.add(key);
           }
         }
        return countMap.size();
    }
}
