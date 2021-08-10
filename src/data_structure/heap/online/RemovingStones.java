package data_structure.heap.online;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RemovingStones {

    public static void main(String[] args) {
        System.out.println(maximumScore(4, 4, 6));
    }

    public static int maximumScore(int a, int b, int c) {
        int count = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        maxheap.addAll(Arrays.asList(a, b, c));
        while (true) {
            int f = maxheap.poll();
            int s = maxheap.poll();
            if (f == 0 || s == 0) {
                break;
            }
            count++;
            maxheap.add(f - 1);
            maxheap.add(s - 1);
        }
        return count;
    }

    public static int maximumScoreIterative(int a, int b, int c) {
        int [] arr = {a,b,c};
        Arrays.sort(arr);
        if(arr[2] > arr[0]+arr[1]){
            return arr[0]+arr[1];
        }
        return arr[2]+(arr[0]+arr[1]-arr[2])/2;
    }



}
