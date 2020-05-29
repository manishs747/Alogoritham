package arrays.online;


import utils.ArrayUtils;

import java.util.Collections;

/*
https://leetcode.com/problems/flipping-an-image/
 */
public class FlipImage {

    public static void main(String[] args) {
        int [][] A =  {
            {
                1, 1, 0
            },{
                1, 0, 1
            },{
                0, 0, 0
            }
        };
        flipAndInvertImage(A);
    }


    public static int[][] flipAndInvertImage(int[][] A) {
        for (int [] a:A) {
            reverse(a);
            invert(a);
        }
        return A;
    }


    public static void invert(int [] A){
        for(int i=0;i < A.length;i++){
            A[i] = A[i] == 0 ? 1:0;
        }
    }



    public static void reverse(int [] A){
       int i = 0,j=A.length -1;
       while (i < j){
           int tmp = A[i];
           A[i++] = A[j];
           A[j--] = tmp;
       }
    }

}
