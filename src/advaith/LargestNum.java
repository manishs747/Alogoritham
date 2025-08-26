package advaith;

public class LargestNum {

    public static void main(String[] args) {
        int []  arr = { 1,4,7,9};

        System.out.println(findLargestNum(arr));
    }

    public static int findLargestNum(int [] nums){
        int max = 0;
        for (int num:nums) {
           if (num > max){
               max = num;
           }
        }
        return max;
    }


    public static int findLargestNum2(int [] nums){
        int max = 0;
        for (int num:nums) {
            if(num > max){
                max = num;
            }
        }
        return max;
    }
}
