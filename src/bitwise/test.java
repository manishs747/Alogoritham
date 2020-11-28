package bitwise;
//https://www.youtube.com/watch?v=NLKQEOgBAnw

import java.util.Arrays;

public class test {


    public static void main(String[] args) {
        int [] arr = {1,5};
        System.out.print(canMakeArithmeticProgression(arr));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff  = arr[1] -arr[0];
        for (int i = 2;i < arr.length;i++){
            if(diff != arr[i]-arr[i-1]){
                return false;
            }
        }
       return true;
    }

}
