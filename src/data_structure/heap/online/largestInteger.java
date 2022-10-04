package data_structure.heap.online;

import java.util.Comparator;
import java.util.PriorityQueue;

public class largestInteger {

    public static void main(String[] args) {
       int num = 247;
       System.out.println(largestInteger(num));
    }

    public static int largestInteger(int num) {
        PriorityQueue<Integer> maxHeapEven = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxHeapOdd = new PriorityQueue<>(Comparator.reverseOrder());
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            int a = Character.getNumericValue(strNum.charAt(i));
            if (a % 2 == 0)
                maxHeapEven.add(a);
            else
                maxHeapOdd.add(a);
        }
        int result = 0;
        for (int i = 0; i < strNum.length(); i++) {
            int a = Character.getNumericValue(strNum.charAt(i));
            result = result * 10 + (a % 2 == 0 ? maxHeapEven.poll() : maxHeapOdd.poll());
        }
        return result;
    }
}
