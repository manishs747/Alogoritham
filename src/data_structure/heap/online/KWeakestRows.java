package data_structure.heap.online;

import java.util.PriorityQueue;

/**
 *
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 * https://www.baeldung.com/java-8-sort-lambda
 *
 */
public class KWeakestRows {

    public static void main(String[] args) {
        int arr[][] = {
                {1,1,0,0,0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};

        //System.out.println(Integer.compare(15, 15));

        int   arr1 [] = {1,1,0,0,0} ;
        System.out.println(getCount(arr1));


       // kWeakestRows(arr,3);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b) -> a[0] != b[0] ?b[0]-a[0]:b[1]-a[1]);
        for (int i =0;i < mat.length;i++) {
            minHeap.add(new int[]{getCount(mat[i]),i});
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        int[] ans = new int[k];
        while (k > 0){
            ans[--k] = minHeap.poll()[1];
        }
        return ans;
    }

    private static int getCount(int[] ints) { // binary search
        int start = 0,end = ints.length;
        while (start < end){
           int mid = start+(end-start)/2; //4
            if(ints[mid] ==  1){
                start = mid+1;
            }else{
                end = mid ;
            }
        }
        return start;
    }


    private static int getCountIterative(int[] ints) {
        int count = 0;
        for (int num: ints) {
            if(num == 0){
                break;
            }
            count++;
        }
        return count;
    }
}
