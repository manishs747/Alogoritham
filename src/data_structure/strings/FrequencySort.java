package data_structure.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sort-characters-by-frequency/
Given a string, sort it in decreasing order based on the frequency of characters.
"datastructure.strings.datastructure.strings.tree" / "eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


 */

//good solution

public class FrequencySort {
    public static void main(String[] args) {
        String word = "data_structure/tree";
        System.out.println(frequencySort(word));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> charCountMap.get(b) - charCountMap.get(a));
        maxHeap.addAll(charCountMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for (int i = 0; i < charCountMap.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }



}
