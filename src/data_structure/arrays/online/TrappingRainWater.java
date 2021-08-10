package data_structure.arrays.online;


/***
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {


    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
        int arr1[] = {4, 2, 0, 3, 2, 5};//9
        System.out.println(trap(arr1));
    }

    public static int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int[] rmax = new int[len];
        int max = height[len - 1];
        for (int i = len - 2; i > 0; i--) {
            rmax[i] = max;
            max = Math.max(max, height[i]);
        }
        int water = 0;
        max = height[0];
        for (int i = 0; i < len - 1; i++) {
            int min = Math.min(max, rmax[i]);
            max = Math.max(max, height[i]);
            water += min - height[i] > 0 ? min - height[i] : 0;
        }
        return water;
    }


    public int trapOnePass(int[] height) {
        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1, rainWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    rainWater += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    rainWater += rightMax - height[right];
                }
                right--;
            }
        }
        return rainWater;
    }
}
