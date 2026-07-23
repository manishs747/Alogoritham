package company.google.trapwater;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 */
public class ContainerWithMaxWater {

    public static void main(String[] args) {
       int [] arr =  {1,8,6,2,5,4,8,3,7}; //49
        System.out.println(maxArea(arr));
    }


    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0 , right = height.length - 1;
        while (left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea,area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
         return maxArea;
    }

}
