package data_structure.strings.online;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {


    public static void main(String[] args) {
        String order = "cba", str = "abcdabc";//ccbbaad
        System.out.println(customSortString(order, str));
    }


    public static String customSortStringOptimized(String order, String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            ++count[c - 'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String customSortString(String order, String str) {
        int[] orderArr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (orderArr[a - 'a'] - orderArr[b - 'a']));
        for (char s : str.toCharArray()) {
            pq.add(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}
