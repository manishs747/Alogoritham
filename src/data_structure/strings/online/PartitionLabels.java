package data_structure.strings.online;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String s = "e";
        System.out.println(partitionLabels(s)); //[9,7,8]
    }


    public static List<Integer> partitionLabels(String S) {
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int prev = -1;
        int current = 0;
        int max = index[S.charAt(0) - 'a'];
        while (current < S.length()) {
            if (index[S.charAt(current) - 'a'] > max) {
                max = index[S.charAt(current) - 'a'];
            }
            if (current == max) {
                result.add(current - prev);
                prev = current;
            }
            current++;
        }
        return result;
    }

    public static List<Integer> partitionLabels2(String S) {
        char [] letters = S.toCharArray();
        List<Integer> result = new ArrayList<>();
        int[] position = new int[26];
        for (int i = 0; i < letters.length; i++) {
            position[letters[i] - 'a'] = i;
        }
        for (int i = 0, prev = -1, max = 0; i < letters.length; i++) {
            if (position[letters[i] - 'a'] > max) max = position[letters[i] - 'a'];
            if (i == max) {
                result.add(i - prev);
                prev = i;
            }
        }
        return result;
    }


}
