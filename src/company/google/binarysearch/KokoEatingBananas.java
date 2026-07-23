package company.google.binarysearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class KokoEatingBananas {

    public static void main(String[] args) {
      int []   piles = {3,6,7,11};
      int h = 8;
        System.out.println(minEatingSpeed(piles,h)); //4
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int ls = 1 , rs = Arrays.stream(piles).max().getAsInt();
        while (ls < rs){
            int mid = (ls + rs) /2;
            if(getHours(piles,mid) <= h){
                rs = mid;
            }else{
                ls =  mid + 1;
            }
        }
        return ls;
    }


    public static int getHours(int [] piles , int speed){
          int hours = 0 ;
          for (int pile : piles){
              hours +=   (int)Math.ceil((double)pile / speed);
          }
        return hours;
    }



}
