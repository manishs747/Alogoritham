package data_structure.heap.online;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MinimumOperations {

    public static void main(String[] args) {
       int [] arr  = {1,5,0,3,5};
        System.out.println(minimumOperations(arr));
    }

    public int minimumOperations2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a: nums)
            if (a > 0)
                set.add(a);
        return set.size();
    }
    public static int minimumOperations(int[] nums) {
        Queue<Integer> primary = new PriorityQueue<>();
        Queue<Integer> secondary = new PriorityQueue<>();
        for (int n:nums)
            if(n != 0) primary.add(n);
        int count = 0;
        while (!primary.isEmpty() || !secondary.isEmpty()){
            int min = primary.poll();
            while (!primary.isEmpty()){
                int num = primary.poll()-min;
                if(num != 0){
                    secondary.add(num);
                }
            }
            Queue<Integer> tmp = primary;
            primary = secondary;
            secondary = tmp;
            count++;
        }
        return count;
    }
}
