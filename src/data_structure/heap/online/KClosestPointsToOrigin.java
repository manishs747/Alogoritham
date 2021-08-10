package data_structure.heap.online;


import utils.ArrayUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] arr = {
                {3, 3}, {5, -1}, {-2, 4}
        };
        ArrayUtils.print(kClosest(arr, 2));
    }


    public static int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (points[b][0] * points[b][0] + points[b][1] * points[b][1] - points[a][0] * points[a][0] - points[a][1] * points[a][1]));
        for (int i = 0; i < points.length; i++) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        while (k-- > 0) {
            result[k] =  points[maxHeap.poll()];
        }
        return result;
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }


    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}
