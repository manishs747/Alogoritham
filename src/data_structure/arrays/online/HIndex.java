package data_structure.arrays.online;

import java.util.Arrays;
import java.util.Collections;


/**
 * https://leetcode.com/problems/h-index/
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndex {
    public static void main(String[] args) {
        int [] citations = {0};
        System.out.println(hIndex2(citations));

    }
    public static int hIndexBinarySearch(int[] citations) {
       /* Arrays.sort(citations);
        int left = 0, right =  citations.length-1;
        while (left < right){
            int mid = left + (right - left)/2;
            if(citations[citations.length-1-mid] >= mid && (mid != left && citations[citations.length-1-mid+1] >= mid)){

            }
        }
        while (i < citations.length && citations[citations.length-1-i] >= i){
            i++;
        }
        return i;*/
        return -1;
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length-1-i] >= i){
            i++;
        }
        return i;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        //0,1,3,5,6
        int i = 0;
        while (i < citations.length && citations[i] <= i){
            i++;
        }
        return citations.length-1-i;
    }
}
