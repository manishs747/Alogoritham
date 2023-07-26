package data_structure.heap.online;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/total-cost-to-hire-k-workers/description/
 */
public class TotalCost {

    public static void main(String[] args) {
        int[] cost = {18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75};
        System.out.println(totalCost(cost, 13, 23));
    }


    public static long totalCost(int[] costs, int k, int candidates) {
        Queue<Integer> pql = new PriorityQueue<>(), pqr = new PriorityQueue<>();
        int p = 0, q = costs.length - 1;
        for (int i = 0; i < candidates && p <= q; i++)
                pql.add(costs[p++]);

        for (int i = 0; i < candidates && p <= q; i++)
            pqr.add(costs[q--]);

        long total = 0;
        while (k-- > 0) {
            if (pqr.isEmpty()  ||( !pql.isEmpty() && pql.peek() <= pqr.peek()) ){
                total += pql.poll();
                if (p <= q) pql.add(costs[p++]);
            } else {
                total += pqr.poll();
                if (p <= q) pqr.add(costs[q--]);
            }
        }
        return total;
    }

    public static long totalCost2(int[] costs, int k, int candidates) {
        Queue<Integer> pql = new PriorityQueue<>(), pqr = new PriorityQueue<>();
        int p = 0, q = costs.length - 1;
        long total = 0;
        while (k-- > 0) {
            while (pql.size() < candidates && p <= q )
                pql.add(costs[p++]);
            while (pqr.size() < candidates && p <= q )
                pqr.add(costs[q--]);
            int t1 = pql.size() > 0 ? pql.peek() : Integer.MAX_VALUE;
            int t2 = pqr.size() > 0 ? pqr.peek() : Integer.MAX_VALUE;
            if (t1 <= t2) {
                total += t1;
                pql.poll();
            } else {
                total += t2;
                pqr.poll();
            }
        }
        return total;
    }



    public static long totalCost3(int[] costs, int k, int candidates) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Use a max heap
        int p = 0, q = costs.length - 1;
        long total = 0;
        while (k-- > 0) {
            while (pq.size() < candidates && p <= q)
                pq.add(costs[p++]);
            while (pq.size() < candidates && p <= q)
                pq.add(costs[q--]);

            int t1 = pq.size() > 0 ? pq.poll() : Integer.MIN_VALUE;
            int t2 = pq.size() > 0 ? pq.poll() : Integer.MIN_VALUE;

            total += t1 + t2;
        }
        return total;
    }








}
