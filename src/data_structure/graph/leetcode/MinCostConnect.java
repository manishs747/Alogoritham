package data_structure.graph.leetcode;


import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */
public class MinCostConnect {


    public static void main(String[] args) {

        int [][] points =  {{2,-3},{-17,-8},{13,8},{-17,-15}};//20
        System.out.println(minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        PriorityQueue<int [][]> minHeap = new PriorityQueue<>(Comparator.comparingInt(MinCostConnect::edgeLength));
        buildMinHeap(minHeap,points);
        int count = 0 , weight = 0;
        Set<int[]> vistedSet = new HashSet<>();
        while (count < points.length-1){
            int[][] minEdge = minHeap.poll();
            if(vistedSet.contains(minEdge[0]) && vistedSet.contains(minEdge[1])) continue;
            weight += edgeLength(minEdge);
            vistedSet.add(minEdge[0]);
            vistedSet.add(minEdge[1]);
            count++;
        }
        return weight;
    }
    
    public static void buildMinHeap(PriorityQueue<int [][]> minHeap ,int [][] points ){
        for (int i = 0; i < points.length ; i++)
            for (int j = i+1; j < points.length; j++)
                minHeap.add(new int[][]{points[i],points[j]});
    }

    public static int edgeLength(int edge [][]){
        return Math.abs(edge[0][0] - edge[1][0]) + Math.abs(edge[0][1] - edge[1][1]);
    }
}
