package data_structure.arrays;


/**
 * https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
      int []  height = {1,8,6,2,5,4,8,3,7};
    }

    public int maxArea(int[] height) {
        int maxWater = 0,left  = 0, right = height.length-1;
        while (left < right){
            maxWater = Math.max(maxWater,(right-left)*Math.min(height[left],height[right])) ;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
