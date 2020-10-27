package algorithams.sorting.online;


import utils.ArrayUtils;

/*
https://leetcode.com/problems/sort-colors/
 */
public class SortColor {
    public static void main(String[] args) {
        int arr [] = {2,0,1};
        sortColors(arr);
        ArrayUtils.print(arr);
    }

    public static void sortColors(int[] nums) {
        int i = 0,c = 0,j=nums.length-1;
        while (c <= j){
            int num = nums[c];
            if(num == 2){
                swap(nums,c,j--);
            }else if (num == 0){
              swap(nums,c++,i++);
            }else{
                c++;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
