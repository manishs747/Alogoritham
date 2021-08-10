package data_structure.arrays.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class KClosestElements {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2, x = 3;
        System.out.println(findClosestElementsTwoPointer(arr, k, x));

    }


    /**
     * Sort With Custom Comparator
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> sortedArr = new ArrayList<>();
        for (int n : arr) {
            sortedArr.add(n);
        }
        Collections.sort(sortedArr, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
        sortedArr = sortedArr.subList(0, k);
        Collections.sort(sortedArr);
        return sortedArr;
    }


    public static List<Integer> findClosestElementsTwoPointer(int[] arr, int k, int x) {
        List<Integer> sortedArr = new ArrayList<>();
        int start = 0, end = arr.length - 1;
        while (end - start + 1 > k) {
            if (Math.abs(arr[start] - x) - Math.abs(arr[end] - x) > 0) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = start; i <= end; i++) {
            sortedArr.add(arr[i]);
        }
        return sortedArr;
    }
}
