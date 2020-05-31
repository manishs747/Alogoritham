package arrays.online;

import java.util.*;

public class test {


    public static void main(String[] args) {
    }




    public static boolean hasAllCodes(String s, int k) {
        List<String> binaryList = new ArrayList<>();
        getAllBinary(k, new int[k], 0,binaryList);
        for (String str:binaryList) {
            if(!s.contains(str)){
                return false;
            }
        }
        return true;
    }

        static void getAllBinary(int n,int arr[], int i,List<String> binaryList)
        {
            if (i == n) {
               binaryList.add(getWord(arr));
                return;}
            arr[i] = 0;
            getAllBinary(n, arr, i + 1,binaryList);
            arr[i] = 1;
            getAllBinary(n, arr, i + 1,binaryList);
        }

        public static String getWord(int arr[]){
            StringBuilder sb = new StringBuilder();
            for (int i :arr){
                sb.append(i);
            }
            return sb.toString();
        }

}

