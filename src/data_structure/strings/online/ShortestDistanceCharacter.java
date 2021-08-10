package data_structure.strings.online;


import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */
public class ShortestDistanceCharacter {


    public static void main(String[] args) {
        ArrayUtils.print(shortestToChar("loveleetcode", 'e'));
    }


    /**
     * 0 sec
     */
    public static int[] shortestToChar2Pass(String s, char c) {
        int[] ans = new int[s.length()];
        char[] arr = s.toCharArray();
        int pos = -arr.length;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == c) pos = i;
            ans[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (arr[i] == c) pos = i;
            if (pos - i < ans[i]) {
                ans[i] = pos - i;
            }
        }
        return ans;
    }


    /**
     * 0 sec Solution
     */
    public static int[] shortestToChar(String s, char c) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] answer = new int[len];
        int distance = len;
        for (int i = 0; i < len; ++i) {
            if (arr[i] == c) {
                distance = 0;
            } else {
                ++distance;
            }
            answer[i] = distance;
        }
        distance = len;
        for (int i = len - 1; i >= 0; --i) {
            if (arr[i] == c) {
                distance = 0;
            } else {
                ++distance;
            }
            if (distance < answer[i]) {   //its taking less time for this step
                answer[i] = distance;
            }
        }

        return answer;
    }


    public static int[] shortestToCharBadSol(String s, char c) {
        int[] ans = new int[s.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                list.add(i);
            }
        }
        System.out.println(list);
        for (int i = 0; i < s.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int n : list) {
                min = Math.min(min, Math.abs(i - n));
            }
            ans[i] = min;
        }
        return ans;
    }
}
