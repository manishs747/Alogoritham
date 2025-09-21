package data_structure.heap.online;

import opennlp.tools.util.Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/description/?envType=company&envId=amazon&favoriteSlug=amazon-six-months
 */
public class ReorganizeString {

    public static void main(String[] args) {
         String s = "aab"; // aba
         System.out.println(reorganizeString(s));
    }


    public static String reorganizeString(String s) {
       StringBuilder sb = new StringBuilder();
       Map<Character,Integer> countMap = new HashMap<>();
        for (char c:s.toCharArray()) {
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.comparingInt(countMap::get).reversed());
        for (char c:countMap.keySet()) {
            maxHeap.add(c);
        }
        while (!maxHeap.isEmpty()){
            char first = maxHeap.poll();
            sb.append(first);
            if(maxHeap.isEmpty() &&  countMap.get(first) > 1) return "";
            if(maxHeap.isEmpty() &&  countMap.get(first) == 1) break;
            char second = maxHeap.poll();
            sb.append(second);
            int firstCount = countMap.get(first) , secondCount = countMap.get(second);
            if(firstCount > 1){
                countMap.put(first,firstCount-1);
                maxHeap.add(first);
            }
            if(secondCount > 1){
                countMap.put(second,secondCount-1);
                maxHeap.add(second);
            }
        }
       return sb.toString();
    }
}
