package algorithams.twopointer;

import java.util.HashMap;
import java.util.Map;

public class TrappingRainWater {


    public static void main(String[] args) {
       int [] height = {0,2,0,3,1,0,1,3,2,1};
       System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int [] rightH = new int[height.length];
        int totalWater = 0 , maxRight = 0 , maxLeft = 0;
        for (int i = height.length-1; i >= 0; i--) {
            maxRight =  Math.max(maxRight,height[i]);
            rightH[i] = maxRight;
        }
        for (int i = 0; i < height.length ; i++) {
            maxLeft =  Math.max(maxLeft,height[i]);
            int water = Math.min(maxLeft,rightH[i]) - height[i];
            if(water > 0){
                totalWater += water;
            }
        }
        return totalWater;
    }
}
