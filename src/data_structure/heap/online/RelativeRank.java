package data_structure.heap.online;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRank {


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        ArrayUtils.print(findRelativeRanks(arr));
    }

     //good solution
    public String[] findRelativeRanksoPtimised(int[] score) {
        String[] topThree = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (score[o2] - score[o1]));
        for (int i = 0; i < score.length; i++) {
            queue.add(i);
        }
        String[] str = new String[score.length];
        int i = 1;
        while (!queue.isEmpty()) {
            str[queue.poll()] = i > 3 ? String.valueOf(i) : topThree[i - 1];
            i++;
        }
        return str;
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        String[] topThree = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : score) {
            maxHeap.add(num);
        }
        Map<Integer, String> rankMap = new HashMap<>();
        int count = 0;
        while (!maxHeap.isEmpty()) {
            count++;
            rankMap.put(maxHeap.poll(), count < 4 ? topThree[count - 1] : String.valueOf(count));
        }
        System.out.println(rankMap);
        for (int i = 0; i < score.length; i++) {
            result[i] = rankMap.get(score[i]);
        }
        return result;
    }
}

