package company.google.trapwater;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 */
public class TrappingRainWater {


    public static void main(String[] args) {
      int [] water =   {0,1,0,2,1,0,1,3,2,1,2,1}; //6
        System.out.println(trap(water));
    }

    public static int trap(int[] height) {
        int [] lastMax = getLastMaxArray(height);
        int max = 0;
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int diff = Math.min(max, lastMax[i]) - height[i];
            if (diff > 0){
                water += diff;
            }
            max = Math.max(max, height[i]);
        }
        return water;
    }

    public static int [] getLastMaxArray( int [] water){
        int [] lastMax = new int[water.length];
        int max = 0;
        for (int i = water.length-1; i >= 0; i--) {
           lastMax[i] = max;
           max  = Math.max(max, water[i]);
        }
        return lastMax;
    }


}
