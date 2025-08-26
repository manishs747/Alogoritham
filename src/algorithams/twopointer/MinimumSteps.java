package algorithams.twopointer;


/**
 * https://leetcode.com/problems/separate-black-and-white-balls/?envType=daily-question&envId=2024-10-15
 */
public class MinimumSteps {

    public static void main(String[] args) {
        String  s = "10101";
        System.out.println(s);
        System.out.println(minimumSteps(s));

    }

    public static long minimumSteps(String s) {
        int swapCount = 0 , zeroPointer = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')
                swapCount += i-zeroPointer++;
        }
        return swapCount;
    }



    public static long minimumStepsBrute(String s) {
       int swapCount = 0;
       char [] arr = s.toCharArray();
       boolean isOrdered = false;
       while (!isOrdered){
           isOrdered = true;
           for(int i = 0 ; i < arr.length-1;i++){
               if(arr[i] == '1' && arr[i+1] == '0'){
                   isOrdered = false;
                   arr[i] = '0' ;
                   arr[i+1] = '1';
                   swapCount++;
               }

           }
       }
       System.out.println(arr);
       return swapCount;
    }











    public static long minimumSteps2(String s) {
        int start = 0 , end = s.length()-1 , numberOfSwap = 0;
        while (start < end){
            while (start < end && s.charAt(start) == '0')
                start++;
            while (start < end && s.charAt(end) == '1')
                end--;
            if(s.charAt(start) == '1' && s.charAt(end) == '0'){
                start++;
                end--;
                numberOfSwap++;
            }else{
                break;
            }
        }
       return numberOfSwap;
    }
}
