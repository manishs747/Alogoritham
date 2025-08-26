package Interview.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
       List list = new ArrayList();


    }



































    public static List<Integer> canSum(int targetSum , int [] arr ){
        return canSum(targetSum,arr, 0);
    }

    public static List<Integer> canSum(int targetSum , int [] arr , int index){
        if(targetSum == 0 ) return new ArrayList<>();
        if(index < arr.length) return null;
        int current = arr[index];
        List<Integer> list = canSum(targetSum - current, arr, index + 1);
        if(list != null){
            list.add(current);
            return list;
        }
        list = canSum(targetSum , arr, index + 1);
        if(list != null){
            list.add(current);
            return list;
        }
        return list;
    }
}
