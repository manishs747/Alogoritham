package data_structure.heap.online;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    public static void main(String[] args) {
       String s = "tree";
        System.out.println(frequencySort(s));
    }


    public static String frequencySort(String s) {
        Map<Character,Integer> charCountMap = new HashMap<>();
        for (char c:s.toCharArray())
            charCountMap.put(c,  charCountMap.getOrDefault(c,0)+1);
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.comparingInt(charCountMap::get).reversed());
        for (char c:charCountMap.keySet())
            maxHeap.add(c);
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            for (int i = 0; i < charCountMap.get(c) ; i++)
                sb.append(c);
        }
        return sb.toString();
    }

    public static String frequencySort2(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray())
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        TreeMap<Character, Integer> sortedMap = new TreeMap<>(charCountMap);
        StringBuilder sb = new StringBuilder();
        sortedMap.forEach((character, frequency) ->
                sb.append(String.valueOf(character).repeat(frequency)));
        return sb.toString();
    }
}
