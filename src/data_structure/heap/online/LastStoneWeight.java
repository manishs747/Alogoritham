package data_structure.heap.online;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
         int [] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone:stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1){
            int lar = maxHeap.poll();
            int small = maxHeap.poll();
            if(lar > small){
                maxHeap.add(lar - small);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
