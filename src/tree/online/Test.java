package tree.online;

import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int n [] = new int[len];

        for (int i=0;i<len;i++){
            n[i] = in.nextInt();
        }
        System.out.println(toys(n));

    }

    static int toys(int[] w) {
        Arrays.sort(w);
        ArrayUtils.print(w);
        System.out.println();
        int count = 0;
        if(null == w || w.length == 0){
            return 0;
        }
        int min = -1;
        for (int n: w ) {
            if(n > min){

                System.out.println("New Contain:"+n);
                count++;
                min = n+4;
            }
        }
        return count;
    }
}
