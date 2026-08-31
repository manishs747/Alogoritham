package data_structure.heap.online;

import java.util.*;

/**
 * https://leetcode.com/problems/reorganize-string/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days
 */
public class ReorganizeStringNew {

    public static void main(String[] args) {

        String str = "abbabbaaab";//aba
        System.out.println(reorganizeString(str));

    }




    public static String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()){
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
        }
        Queue<Character> maxHeap = new PriorityQueue<>( Comparator.<Character, Integer>comparing(charCountMap::get)
                .reversed()
                .thenComparing(c -> c));
        for (char c : charCountMap.keySet()){
            maxHeap.add(c);
        }
        while (!maxHeap.isEmpty()){
            char firstChar = poll(maxHeap,sb,charCountMap);
            if(maxHeap.isEmpty() && charCountMap.get(firstChar) > 0) return "";
            if(!maxHeap.isEmpty()){
            char secondChar =  poll(maxHeap,sb,charCountMap);
                if(charCountMap.get(secondChar) > 0)
                    maxHeap.add(secondChar);
            }
            if(charCountMap.get(firstChar) > 0)
                maxHeap.add(firstChar);

        }
       return sb.toString();
    }

    private static char poll(Queue<Character> maxHeap,StringBuilder sb ,Map<Character, Integer> charCountMap) {
        char second = maxHeap.poll();
        sb.append(second);
        int newSecCount = charCountMap.get(second)-1;
        charCountMap.put(second ,newSecCount );
        return second;
    }


}
